package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your film : ");
        Request request = new Request.Builder()
                    .url("http://www.omdbapi.com/?t="+scanner.nextLine()+"&apikey=8de0f502")
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Gson gson = new Gson();
                assert response.body() != null;
                Movie movie = gson.fromJson(response.body().string(),Movie.class);
                System.out.println("\nActors : "+movie.getActors());
                System.out.println("Year : "+movie.getYear());
                System.out.println("Ratings : \n=============================");
                movie.getRatings().forEach(rating -> {
                    System.out.println("From : "+rating.getSource());
                    System.out.println("Rate : "+rating.getValue());
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}