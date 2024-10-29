package com.conversor.monedas.data;

import com.conversor.monedas.model.Coins;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataApi {
    public Coins coinInformation (String coinsName){
        URI apiUrl = URI.create("https://v6.exchangerate-api.com/v6/8b19f2c450bf86954ef0a2c9/latest/"+ coinsName);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUrl)
                .build();

        try {
            HttpResponse<String> response = null;

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Coins.class);
        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Coins Not found.");
        }

    }
}
