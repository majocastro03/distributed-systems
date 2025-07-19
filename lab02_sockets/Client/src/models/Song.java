package models;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String genre;
    private String author;
    private String language;
    private int year;

    public Song() {}

    public Song(String title, String genre, String author, String language, int year) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.language = language;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getAuthor() { return author; }
    public String getLanguage() { return language; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return String.format("%s - %s (%s, %s, %d)", title, author, genre, language, year);
    }
}
