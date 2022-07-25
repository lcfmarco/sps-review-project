package com.example.demo.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.demo.data.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListMoviesServlet {
    @GetMapping("/list-movies")
    List<Movie> getTest() {
        Datastore datastore =DatastoreOptions.newBuilder()
        .setProjectId("asanchez-sps-summer22")
        .build().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Movies").build();
        QueryResults<Entity> results = datastore.run(query);

        List<Movie> moviesList = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();

            String title = entity.getString("Title");
            String image = entity.getString("Image");
            String director = entity.getString("Director");
            String rating = entity.getString("Rating");
            // Integer rating = entity.("Rating");

            // Movie movie = new Movie(title, image, director, rating);
            Movie movie = new Movie(title, image, director, rating);
            moviesList.add(movie);
        }

        return moviesList;
    }
}