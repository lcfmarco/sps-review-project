package com.example.demo.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @WebServlet("/post-rating")
@RestController

public class PostRatingServlet {
        @PostMapping("/post-rating")
        
        public String addRating(@RequestParam String rating) throws IOException {
          // Sanitize user input to remove HTML tags and JavaScript.
          System.out.println("The key is " + rating);
          return rating;
        //   String rating = Jsoup.clean(request.getParameter("rating"), Whitelist.none());

        //   Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        //   KeyFactory keyFactory = datastore.newKeyFactory().setKind("Movies");
        //   FullEntity taskEntity =
        //       Entity.newBuilder(keyFactory.newKey())
        //           .set("rating", rating)
        //           .build();
        //   datastore.put(taskEntity);

        //   response.sendRedirect("/movies.html");
            

        }
}
