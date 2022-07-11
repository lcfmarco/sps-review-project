package com.example.demo.data;

public class Book {
    private final String author;
    private final String title;
    private final String genre;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String getTitle (){
        return this.title;
    }

    public String getGenre (){
        return this.genre;
    }

    public String getAuthor (){
        return this.author;
    }
}

