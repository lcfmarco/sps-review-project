package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

@RestController
public class MyController {
    @GetMapping("/")
    List<String> getTest(){
        Datastore datastore =DatastoreOptions.newBuilder()
        .setProjectId("just-strength-326117")
        .build().getService();
        //Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("title", "testtitle")
            .set("timestamp", System.currentTimeMillis())
            .build();
    datastore.put(taskEntity);

        return Arrays.asList(new String[] { "A", "B", "C", "D" });
    }
}
