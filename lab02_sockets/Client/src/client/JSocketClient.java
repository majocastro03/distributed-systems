package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import models.Song;

public class JSocketClient {
    private String host;
    private int port;

    public JSocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    @SuppressWarnings("unchecked")
    public List<Song> sendQuery(String type, String query) {
        try (
            Socket socket = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            // Enviar tipo de búsqueda y consulta
            out.writeObject(type);
            out.writeObject(query);
            out.flush();

            // Recibir lista de canciones
            return (List<Song>) in.readObject();

        } catch (Exception e) {
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
            return List.of();
        }
    }
    public void searchLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Buscar canciones (escribe 'salir' para terminar)");
            System.out.print("Tipo de búsqueda (title, genre, author): ");
            String type = scanner.nextLine().trim().toLowerCase();

            if (type.equals("salir")) break;
            if (!type.equals("title") && !type.equals("genre") && !type.equals("author")) {
                System.out.println("Tipo inválido. Usa title, genre o author.");
                continue;
            }

            System.out.print("Término de búsqueda: ");
            String query = scanner.nextLine().trim();
            if (query.equalsIgnoreCase("salir")) break;

            List<Song> results = sendQuery(type, query);
            if (results.isEmpty()) {
                System.out.println("No se encontraron resultados.");
            } else {
                System.out.println("Resultados encontrados:");
                for (Song song : results) {
                    System.out.println("- " + song);
                }
            }
        }
        scanner.close();
        System.out.println("Cliente finalizado.");
    }
}
