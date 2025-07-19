package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import models.Song;

public class SongService {
    private static List<Song> songs;

    static {
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Song>>(){}.getType();
            songs = gson.fromJson(new FileReader("C:/Users/maria/OneDrive - UPB/UPB/8 SEMESTRE/Sistemas Distribuidos/laboratorios/lab02_sockets/Server/src/data/songs.json"), listType);
            System.out.println("Se cargaron " + songs.size() + " canciones desde el archivo JSON.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Song> getSongs() {
        return songs;
    }
}
