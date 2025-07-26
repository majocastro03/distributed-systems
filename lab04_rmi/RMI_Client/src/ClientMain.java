
import models.Song;
import shared.SongServiceRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SongServiceRMI service = (SongServiceRMI) registry.lookup("SongService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("\nBuscar por (titulo, genero, autor) o 'salir': ");
                String type = scanner.nextLine();
                if (type.equalsIgnoreCase("salir")) break;

                System.out.print("Término de búsqueda: ");
                String term = scanner.nextLine();

                List<Song> results = switch (type.toLowerCase()) {
                    case "titulo" -> service.searchByTitle(term);
                    case "genero" -> service.searchByGenre(term);
                    case "autor" -> service.searchByAuthor(term);
                    default -> {
                        System.out.println("Tipo de búsqueda no válido.");
                        yield null;
                    }
                };

                if (results != null && !results.isEmpty()) {
                    results.forEach(System.out::println);
                } else {
                    System.out.println("No se encontraron resultados.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
