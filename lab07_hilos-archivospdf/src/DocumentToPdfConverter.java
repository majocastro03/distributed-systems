import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DocumentToPdfConverter {

    private static final String LIBREOFFICE_PATH = "C:\\Program Files\\LibreOffice\\program\\soffice.exe"; 
    private static final String OUTPUT_DIR = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab07_hilos-archivospdf\\out";
    private static final String RUTAS_TXT = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab07_hilos-archivospdf\\src\\data\\rutas.txt";

    public static void main(String[] args) {
        // Número de hilos a probar
        int numHilos = 2; 

        File outDir = new File(OUTPUT_DIR);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        List<String> filePaths = leerRutasDesdeTxt(RUTAS_TXT);
        if (filePaths.isEmpty()) {
            System.out.println("No se encontraron rutas en el archivo: " + RUTAS_TXT);
            return;
        }

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numHilos);
        List<Future<String>> futures = new ArrayList<>();

        for (String filePath : filePaths) {
            File inputFile = new File(filePath);
            if (!inputFile.exists()) {
                System.err.println("Archivo no encontrado: " + filePath);
                continue;
            }
            futures.add(executor.submit(() -> convertToPdf(inputFile, outDir)));
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
        for (Future<String> future : futures) {
            try {
                String pdfPath = future.get();
                if (pdfPath != null) {
                    System.out.println(pdfPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            String ext = getExtension(inputFile.getName()).toLowerCase();
            String filter;

            switch (ext) {
                case "doc":
                case "docx":
                    filter = "writer_pdf_Export";
                    break;
                case "ppt":
                case "pptx":
                    filter = "impress_pdf_Export";
                    break;
                case "xls":
                case "xlsx":
                    filter = "calc_pdf_Export";
                    break;
                case "png":
                case "jpg":
                case "jpeg":
                    filter = "draw_pdf_Export";
                    break;
                default:
                    filter = "writer_pdf_Export";
            }

            ProcessBuilder pb = new ProcessBuilder(
                    LIBREOFFICE_PATH,
                    "--headless",
                    "--convert-to", "pdf:" + filter,
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
                return new File(outputDir, pdfName).getAbsolutePath();
            } else {
                System.err.println("Error al convertir: " + inputFile.getAbsolutePath());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
