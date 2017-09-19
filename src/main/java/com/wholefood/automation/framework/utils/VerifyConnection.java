package com.wholefood.automation.framework.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jahangir shaheen on 9/2/2017.
 */
public class VerifyConnection {
    public static  int inValidLink;
    public static void varifyUrl(String urlLink) throws IOException {
        try {
            URL url=new URL(urlLink);
            HttpURLConnection urlConnect=(HttpURLConnection)url.openConnection();
            urlConnect.setConnectTimeout(5000);
            if(urlConnect.getResponseCode()==200){
                System.out.println(urlLink+" : "+urlConnect.getResponseCode()+" : "+urlConnect.getResponseMessage());
            }else if(urlConnect.getResponseCode()==urlConnect.HTTP_NOT_FOUND){
                System.out.println(urlLink+": "+urlConnect.getResponseMessage());
                inValidLink++;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
