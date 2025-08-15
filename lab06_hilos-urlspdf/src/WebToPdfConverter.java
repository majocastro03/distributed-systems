import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebToPdfConverter {

    // Ruta al ejecutable de Chrome/Chromium
    private static final String CHROME_PATH = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    private static final String OUTPUT_DIR = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab06_hilos-urlspdf\\out";
    private static final String INPUT_FILE = "C:\\Users\\maria\\OneDrive - UPB\\UPB\\8 SEMESTRE\\Sistemas Distribuidos\\laboratorios\\lab06_hilos-urlspdf\\src\\data\\urls.txt";

    public static void main(String[] args) {
        // Cantidad de hilos
        int numHilos = 11; 

        List<String> urls = readUrlsFromFile(INPUT_FILE);
        if (urls.isEmpty()) {
            System.out.println("No se encontraron URLs en el archivo: " + INPUT_FILE);
            return;
        }

        File outputFolder = new File(OUTPUT_DIR);
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }

        long startTime = System.currentTimeMillis();

        // Crear pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(numHilos);

        for (String url : urls) {
            executor.submit(() -> convertToPdf(url));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.err.println("Ejecución interrumpida: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nConversión finalizada con " + numHilos + " hilos en " + (endTime - startTime) + " ms");
    }

    // Método para convertir una URL a PDF usando Headless Chrome.
    private static void convertToPdf(String url) {
        try {
            String fileName = url.replaceAll("[^a-zA-Z0-9-_]", "_") + ".pdf";
            String outputPath = OUTPUT_DIR + File.separator + fileName;

            ProcessBuilder pb = new ProcessBuilder(
                    CHROME_PATH,
                    "--headless",
                    "--disable-gpu",
                    "--print-to-pdf=" + outputPath,
                    url
            );
            pb.redirectErrorStream(true);
            Process process = pb.start();
            process.waitFor();

            File pdfFile = new File(outputPath);
            if (pdfFile.exists()) {
                System.out.println("PDF generado: " + pdfFile.getAbsolutePath());
            } else {
                System.err.println("No se pudo generar el PDF para: " + url);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error procesando " + url + ": " + e.getMessage());
        }
    }

    // Método para leer las URLs desde un archivo de texto.
    private static List<String> readUrlsFromFile(String filePath) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    urls.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de URLs: " + e.getMessage());
        }
        return urls;
    }
}
