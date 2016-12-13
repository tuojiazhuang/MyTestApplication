package com.ali.android.httpapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/11/22.
 */
public class HttpURLConnectionUtils {
    URL url = null;
    HttpURLConnection httpURLConnection;
    String receivedContent;
    private static HttpURLConnectionUtils connectionUtils;

    private HttpURLConnectionUtils(String URL){
        try {
            if(httpURLConnection == null){
                url = new URL(URL);
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static HttpURLConnectionUtils getInstance(String URL){
        //双重判断加上同步锁可以解决线程安全问题
        if(connectionUtils == null){
           synchronized (HttpURLConnectionUtils.class){
               if(connectionUtils == null) {
                   connectionUtils = new HttpURLConnectionUtils(URL);
                   return  connectionUtils;
               }
           }
        }
        return  connectionUtils;
    }
    public void huc_initGet() {
        try {
            System.out.println("--------------Enter huc_initGet");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            // httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void huc_initPost() {
        try {
            System.out.println("--------------Enter huc_initPost");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);

            // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
            // 要注意的是connection.getOutputStream会隐含的进行connect。

            httpURLConnection.connect();

            DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            String postContent = URLEncoder.encode("测试", "UTF-8");
            //将要上传的内容写入流中
            outputStream.writeBytes(postContent);
            //刷新、关闭
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String doHttpURL() {
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                System.out.println("******inputStreamReader***" + inputStreamReader);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String inputString = null;
                if ((inputString = bufferedReader.readLine()) != null) {
                    receivedContent += inputString;
                }

            } else {
                receivedContent = "failed response";
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            httpURLConnection.disconnect();
        }
        System.out.println("------------return content:----"+receivedContent);
        return receivedContent;
    }
}




