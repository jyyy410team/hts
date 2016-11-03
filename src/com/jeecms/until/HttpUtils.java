package com.jeecms.until;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * HttpUtils
 *
 * @author xinhe.sun
 * @date 16/5/19
 */
public class HttpUtils {


    public static String post(List<BasicNameValuePair> formparams, String url) {
        String result = "";
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
//            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
//                    System.out.println("--------------------------------------");
                    result = EntityUtils.toString(entity, "UTF-8");
//                    System.out.println("Response content: " + result);
//                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            System.out.println("Http连接错误：");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持的编码：");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常 ：");
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                System.out.println("关闭连接时出现IO异常：");
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String get(String url) throws Exception {
        String result = "";
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpGet httpGet = new HttpGet(url);
        UrlEncodedFormEntity uefEntity;
        try {
//            System.out.println("executing request " + httpGet.getURI());
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
//                    System.out.println("--------------------------------------");
                    result = EntityUtils.toString(entity, "UTF-8");
//                    System.out.println("Response content: " + result);
//                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            System.out.println("Http连接错误：");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持的编码：");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常 ：");
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                System.out.println("关闭连接时出现IO异常：");
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(get("http://api.openweathermap.org/data/2.5/weather?q=Hangzhou,cn&appid=35bc131f1f7b6fc5d281223be86b0e23"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


