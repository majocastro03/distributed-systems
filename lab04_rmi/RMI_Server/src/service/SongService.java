package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Song;
import shared.SongServiceRMI;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class SongService extends UnicastRemoteObject implements SongServiceRMI {
    private static List<Song> songs;
     public SongService() throws RemoteException {
        super();
    }

    public static List<Song> getSongs() {
        if (songs == null) {
            try {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Song>>(){}.getType();
                songs = gson.fromJson(new FileReader("C:/Users/maria/OneDrive - UPB/UPB/8 SEMESTRE/Sistemas Distribuidos/laboratorios/lab04_rmi/RMI_Server/src/data/songs.json"), listType);
                System.out.println("Canciones cargadas: " + songs.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return songs;
    }
     @Override
    public List<Song> searchByTitle(String title) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByGenre(String genre) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAuthor(String author) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    
}
