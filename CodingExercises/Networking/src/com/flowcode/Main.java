package com.flowcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org/somepage.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            connection.setReadTimeout(30000);
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code = " + responseCode);
            if (responseCode != 200) {
                System.out.println("Error reading webpage : " + connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader =  new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while((line = inputReader.readLine()) != null){
                System.out.println(line);
            }

            inputReader.close();


//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("-----key = " + key);
//                for (String string: value){
//                    System.out.println("value = " + value);
//                }
//            }

//            String line = "";
//            while(line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();
//            URI uri = url.toURI();

//            URI baseUri = new URI("http://username:password@myserver.com:4567");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//
//            URI resolvedURI1 = baseUri.resolve(uri1);
//            URI resolvedURI2 = baseUri.resolve(uri2);
//            URI resolvedURI3 = baseUri.resolve(uri3);
//
//            URL url1 = resolvedURI1.toURL();
//            System.out.println("URL 1 = " + url1);
//            URL url2 = resolvedURI2.toURL();
//            System.out.println("URL 2 = " + url2);
//            URL url3 = resolvedURI3.toURL();
//            System.out.println("URL 3 = " + url3);
//
//            URI relativizedURI =  baseUri.relativize(resolvedURI2);
//            System.out.println("Relative URI: " + relativizedURI);
//
////            URI uri = new URI("hello");
//
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());
//
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
