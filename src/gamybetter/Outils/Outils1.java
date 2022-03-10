/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Outils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static javafx.css.StyleOrigin.USER_AGENT;

/**
 *
 * @author Mariem
 */
 public class Outils1 {
    public static final String USER_AGENT = "Mozilla/5.0";
    public static StringBuffer sendGET(String host, String user_id, String api_key) throws IOException {
        //user-id
        //api-key
        String GET_URL = "https://neutrinoapi.net/bad-word-filter" + host + "&user-id=" + user_id + "&api-key=" + api_key;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            System.out.println("strinbuffer"+response);

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response;
        } else {
            System.out.println("GET request not worked");
        }
        return null;

    }
    
}
