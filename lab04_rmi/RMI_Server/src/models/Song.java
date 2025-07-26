package models;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String genre;
    private String author;
    private String language;
    private int releaseYear;

    public Song(String title, String genre, String author, String language, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.language = language;
        this.releaseYear = releaseYear;
    }

    // Getters, setters y toString()
    public String toString() {
        return title + " - " + author + " (" + genre + ", " + language + ", " + releaseYear + ")";
    }

    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
}
