/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skon1
 */
public class HostAPI {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String POST_PARAMS = "userName=Pankaj";

    public static Boolean sendGET(String host, String user_id, String api_key) throws IOException {
        //user-id
        //api-key
        String GET_URL = "https://neutrinoapi.net/host-reputation?host=" + host + "&user-id=" + user_id + "&api-key=" + api_key;
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

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            int index_is_listed;
            // List<Boolean> res_api = new ArrayList();
            Boolean test_site;
            System.out.println(response.toString());
            
                String res = response.toString();
                index_is_listed = res.indexOf("\"is-listed\"");
                res = res.substring(index_is_listed, res.length());
                int index_dp = res.indexOf(":");
                int index_vir = res.indexOf(",");
                String bol = res.substring(index_dp, index_vir);
                test_site = Boolean.parseBoolean(bol);

            return test_site;
        
        } else {
            System.out.println("GET request did not work");
        }
        return true;

    }

    public static String sendGETURLINFO(String url, String user_id, String api_key) throws IOException {
        //user-id
        //api-key
        String GET_URL = "https://neutrinoapi.net/url-info?url=" + url + "&user-id=" + user_id + "&api-key=" + api_key;
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

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            if (response.length() > 0) {
                System.out.println(response.length());
                int index = response.lastIndexOf("server-ip");
                System.out.println(index);

                CharSequence str = response.subSequence(index + 12, index + 30);
                String tstr = str.toString();
                int index2 = tstr.lastIndexOf("\",");
                String last_str = tstr.substring(0, index2);
                System.out.println(last_str);
                return last_str;
            }

        } else {
            System.out.println("GET request did not work");
        }
        return "";

    }

    /*private static void sendPOST(String url, String user_id, String api_key) throws IOException {
        String POST_URL = "https://neutrinoapi.net/url-info";
        URL obj = new URL(POST_URL);
        String urlParameters = "url=" + url + "&user-id=" + user_id + "&api-key=" + api_key;
       

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
       
     
        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(urlParameters.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }*/
}
