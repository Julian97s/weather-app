package weatherapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Reader {
    private String target;
    private String geoCodingApiURL = "https://geocoding-api.open-meteo.com/v1/search?name=";

    public Reader(String city){
        this.target = city.trim().toLowerCase();
        this.geoCodingApiURL += this.target;
    }



    public String getTarget() {
        return target;
    }



    public String getGeoCodingApiURL() {
        return geoCodingApiURL;
    }

    public void fetchApiData(String apiUrl) throws IOException, MalformedURLException  {
        @SuppressWarnings("deprecation")
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);

       if (responseCode == HttpURLConnection.HTTP_OK){
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(connection.getInputStream());

        while (s.hasNext()){
            sb.append(s.nextLine());
        }
        System.out.println(sb);
        ObjectMapper objectMapper = new ObjectMapper();
        GeocodingApiResponse response = objectMapper.readValue(String.valueOf(sb), GeocodingApiResponse.class); // i used this here but why is an extra set of curly braces there?
        // curly braces after a constructor creates a subclass, like a lambda class
        System.out.println(response);
       }
    }
}
