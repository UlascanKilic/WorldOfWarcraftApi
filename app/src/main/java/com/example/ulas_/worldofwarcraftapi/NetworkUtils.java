package com.example.ulas_.worldofwarcraftapi;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //https://us.api.battle.net/wow/zone/?locale=en_US&apikey=7mjwz8undb5esh9z2ugqnsav3hh5fspj
    private static final String ZONE_BASE_URL =  "https://us.api.battle.net/wow/zone/?locale=en_US&apikey=7mjwz8undb5esh9z2ugqnsav3hh5fspj";


    static String getZoneInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String zoneJSONString = null;

 try {
     Uri builtURI = Uri.parse(ZONE_BASE_URL).buildUpon().build();
     URL requestURL = new URL(builtURI.toString());
     urlConnection = (HttpURLConnection) requestURL.openConnection();
     urlConnection.setRequestMethod("GET");
     urlConnection.connect();
     InputStream inputStream = urlConnection.getInputStream();
     StringBuffer buffer = new StringBuffer();
     if (inputStream == null) {
         return null;
     }
     reader = new BufferedReader(new InputStreamReader(inputStream));
     String line;
     while ((line = reader.readLine()) != null) {
         buffer.append(line + "\n");
     }
     if (buffer.length() == 0) {
         return null;
     }
     zoneJSONString = buffer.toString();
 }
 catch (Exception e)
 {
     e.printStackTrace();
     return null;
 }
        finally{
     if (urlConnection != null) {
         urlConnection.disconnect();
     }
     if (reader != null) {
         try {
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
return zoneJSONString;
    }
}
