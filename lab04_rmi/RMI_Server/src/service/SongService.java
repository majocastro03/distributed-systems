package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Song;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class SongService {
    private static List<Song> songs;

    public static List<Song> getSongs() {
        if (songs == null) {
            try {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Song>>(){}.getType();
                songs = gson.fromJson(new FileReader("data/songs.json"), listType);
                System.out.println("Songs loaded: " + songs.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return songs;
    }
    
}
