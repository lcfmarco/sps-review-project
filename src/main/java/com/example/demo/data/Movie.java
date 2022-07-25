package com.example.demo.data;

import org.apache.logging.log4j.util.StringBuilders;

public class Movie {
    private final String director;
    private final String title;
    private final String image;
    private final String rating;

    public Movie(String title, String image, String director, String rating) {
        this.title = title;
        this.image = image;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle () {
        return this.title;
    }

    public String getImage () {
        return this.image;
    }

    public String getDirector () {
        return this.director;
    }

    public String getRating() {
        return this.rating;
    }
}
