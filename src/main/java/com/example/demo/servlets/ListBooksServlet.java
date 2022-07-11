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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.data.*;


// @WebServlet("/list-books")
@RestController
public class ListBooksServlet {
    // public void doGet(HttpServletRequest request, HttpServletResponse response)
    // throws IOException {
    @GetMapping("/list-books")
    List<Book> getTest() {
        Datastore datastore =DatastoreOptions.newBuilder()
        .setProjectId("asanchez-sps-summer22")
        .build().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Books").build();
        QueryResults<Entity> results = datastore.run(query);

        List<Book> booksList = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();

            String title = entity.getString("Title");
            String genre = entity.getString("Genre");
            String author = entity.getString("Author");

            Book book = new Book(title, genre, author); // Create a movie object?
            booksList.add(book);
        }

        return booksList;

        // Gson gson = new Gson();

        // response.setContentType("application/json;");
        // response.getWriter().println(gson.toJson(booksList));
    }
}
