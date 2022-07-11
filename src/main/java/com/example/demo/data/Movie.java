package com.example.demo.data;

public class Movie {
    private final String director;
    private final String title;
    private final String genre;
    // private final int rating;

    public Movie(String title, String genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        // this.rating = rating;
    }

    public String getTitle () {
        return this.title;
    }

    public String getGenre () {
        return this.genre;
    }

    public String getDirector () {
        return this.director;
    }
}
