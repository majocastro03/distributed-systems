import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class DocumentToPdfConverter {

    private static final String LIBREOFFICE_PATH = "C:\\Program Files\\LibreOffice\\program\\soffice.exe"; 
    private static final String OUTPUT_DIR = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab07_hilos-archivospdf\\out";
    private static final String RUTAS_TXT = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab07_hilos-archivospdf\\src\\data\\rutas.txt";
    
    // Semáforo para limitar las conversiones concurrentes de LibreOffice
    private static final Semaphore libreOfficeSemaphore = new Semaphore(1);

    public static void main(String[] args) {
        // Número de hilos a probar
        int numHilos = 16; 

        File outDir = new File(OUTPUT_DIR);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        List<String> filePaths = leerRutasDesdeTxt(RUTAS_TXT);
        if (filePaths.isEmpty()) {
            System.out.println("No se encontraron rutas en el archivo: " + RUTAS_TXT);
            return;
        }

        // Lista sincronizada para los PDFs generados
        List<String> pdfsGenerados = Collections.synchronizedList(new ArrayList<>());

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numHilos);

        for (String filePath : filePaths) {
            executor.submit(() -> {
                File inputFile = new File(filePath);
                if (!inputFile.exists()) {
                    System.err.println("Archivo no encontrado: " + filePath);
                    return;
                }
                
                String pdfPath = convertToPdf(inputFile, outDir);
                if (pdfPath != null) {
                    pdfsGenerados.add(pdfPath);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.err.println("Ejecución interrumpida: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nConversión finalizada con " + numHilos + " hilos en " + (endTime - startTime) + " ms");

        System.out.println("\nPDFs generados:");
        for (String pdfPath : pdfsGenerados) {
            System.out.println(pdfPath);
        }
    }

    private static List<String> leerRutasDesdeTxt(String rutaTxt) {
        List<String> rutas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaTxt))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("\"") && linea.endsWith("\"")) {
                    linea = linea.substring(1, linea.length() - 1);
                }
                if (!linea.isEmpty()) {
                    rutas.add(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de rutas: " + e.getMessage());
        }
        return rutas;
    }

    private static String convertToPdf(File inputFile, File outputDir) {
        try {
            // Usar semáforo para evitar conflictos de LibreOffice
            libreOfficeSemaphore.acquire();
            
            try {
                ProcessBuilder pb = new ProcessBuilder(
                        LIBREOFFICE_PATH,
                        "--headless",
                        "--convert-to", "pdf", 
                        "--outdir", outputDir.getAbsolutePath(),
                        inputFile.getAbsolutePath()
                );

                pb.redirectErrorStream(true);
                Process process = pb.start();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("[LibreOffice] " + line);
                    }
                }

                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    String pdfName = inputFile.getName().replaceFirst("\\.[^.]+$", "") + ".pdf";
                    File pdfFile = new File(outputDir, pdfName);
                    return pdfFile.getAbsolutePath();
                } else {
                    System.err.println("Error al convertir: " + inputFile.getAbsolutePath() + " (código de salida: " + exitCode + ")");
                }
            } finally {
                libreOfficeSemaphore.release();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Excepción al convertir " + inputFile.getAbsolutePath() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}