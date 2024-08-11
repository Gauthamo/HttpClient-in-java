package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {

        final String POST_API_URL = "https://jsonplaceholder.typicode.com/posts";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(POST_API_URL))
                .build();
        HttpResponse<String> resp = client.send(req,HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<Posts> posts = mapper.readValue(resp.body(), new TypeReference<List<Posts>>() {});
        posts.forEach(System.out::println);
    }
}
//https://api.openweathermap.org/data/2.5/weather?lat=77.5946&lon=12.9716&appid=325a95f805aef2165b29df9e88f80619