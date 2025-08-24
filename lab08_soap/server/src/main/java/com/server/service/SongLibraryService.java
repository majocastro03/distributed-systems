package com.server.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.interfaces.SongLibraryInterface;
import com.server.model.Song;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SongLibraryService implements SongLibraryInterface {

    private List<Song> songs;

    public SongLibraryService() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Cargar desde resources
            var is = getClass().getClassLoader().getResourceAsStream("songs.json");
            if (is != null) {
                songs = mapper.readValue(is, new TypeReference<List<Song>>() {
                });
            } else {
                System.out.println("songs.json no encontrado en resources");
                songs = List.of();
            }
        } catch (IOException e) {
            e.printStackTrace();
            songs = List.of();
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return songs.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByGenre(String genre) {
        return songs.stream()
                .filter(s -> s.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAuthor(String author) {
        return songs.stream()
                .filter(s -> s.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }
}
