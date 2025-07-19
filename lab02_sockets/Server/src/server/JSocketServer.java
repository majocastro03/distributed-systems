package server;
import interfaces.InterfaceSong;
import models.Song;
import service.SongService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class JSocketServer implements InterfaceSong {

    private int port;

    public JSocketServer(int port) {
        this.port = port;
    }

    public void listening() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de música iniciado en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())
        ) {
            String type = (String) in.readObject();  // "title", "genre", "author"
            String query = (String) in.readObject();

            List<Song> result;
            switch (type.toLowerCase()) {
                case "title": result = searchByTitle(query); break;
                case "genre": result = searchByGenre(query); break;
                case "author": result = searchByAuthor(query); break;
                default: result = List.of(); break;
            }

            out.writeObject(result);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return SongService.getSongs().stream()
                .filter(s -> s.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByGenre(String genre) {
        return SongService.getSongs().stream()
                .filter(s -> s.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAuthor(String author) {
        return SongService.getSongs().stream()
                .filter(s -> s.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }
}