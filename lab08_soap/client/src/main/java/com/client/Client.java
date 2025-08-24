package com.client;

import com.client.proxy.Song;
import com.client.proxy.SongLibraryInterface;
import com.client.proxy.SongLibraryInterfaceService;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // Crear el "service"
        SongLibraryInterfaceService serviceFactory = new SongLibraryInterfaceService();

        // Obtener la interfaz para llamar al servicio SOAP)
        SongLibraryInterface service = serviceFactory.getSongLibraryInterfacePort();

        Scanner sc = new Scanner(System.in);
        System.out.println("Buscar canciones:");
        System.out.println("1. Por título");
        System.out.println("2. Por género");
        System.out.println("3. Por autor");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el valor de búsqueda: ");
        String value = sc.nextLine();

        List<Song> results = switch (option) {
            case 1 -> service.searchByTitle(value);
            case 2 -> service.searchByGenre(value);
            case 3 -> service.searchByAuthor(value);
            default -> null;
        };

        if (results != null && !results.isEmpty()) {
            results.forEach(song -> System.out.println(
                    song.getTitle() + " - " + song.getAuthor() + " (" + song.getYear() + ") [" + song.getGenre()
                            + "]"));
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }
}
