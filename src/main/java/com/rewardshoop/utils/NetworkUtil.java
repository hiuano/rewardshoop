package com.rewardshoop.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class NetworkUtil {


    /**
     * 发起http网络请求
     *
     * @param requestUrl    链接地址
     * @param requestMethod 方法
     * @param requestOut    输入参数
     * @return 返回的json.toString()
     */
    public static String httpRequest(String requestUrl, String requestMethod, String requestOut) {
        return httpRequest(new HashMap<String, String>(), requestUrl, requestMethod, requestOut);
    }

    /**
     * 发起http网络请求(带请求头)
     *
     * @param head          请求头
     * @param requestUrl    链接地址
     * @param requestMethod 方法
     * @param requestOut    输入参数
     * @return 返回的json.toString()
     */
    public static String httpRequest(Map<String, String> head, String requestUrl, String requestMethod, String requestOut) {
        String result = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);

            if (head.size() != 0) {
                for (String key : head.keySet()) {
                    connection.setRequestProperty(key, head.get(key));
                }
            }

            if (null != requestOut) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(requestOut.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
            result = buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发起https网络请求
     *
     * @param requestUrl    链接地址
     * @param requestMethod 方法
     * @param requestOut    输入参数
     * @return 返回的json.toString()
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String requestOut) {
        return httpsRequest(new HashMap<String, String>(), requestUrl, requestMethod, requestOut);
    }

    /**
     * 发起https网络请求(带请求头)
     *
     * @param head          请求头
     * @param requestUrl    链接地址
     * @param requestMethod 方法
     * @param requestOut    输入参数
     * @return 返回的json.toString()
     */
    public static String httpsRequest(Map<String, String> head, String requestUrl, String requestMethod, String requestOut) {
        String result = null;
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);

            if (head.size() != 0) {
                for (String key : head.keySet()) {
                    connection.setRequestProperty(key, head.get(key));
                }
            }
            if (null != requestOut) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(requestOut.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
            result = buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * post请求
     *
     * @param requestUrl     链接地址
     * @param nameValuePairs 参数
     * @return 返回的json.toString()
     */
    public static String postRequest(String requestUrl, NameValuePair[] nameValuePairs) {
        return postRequest(new HashMap<String, String>(), requestUrl, nameValuePairs);
    }

    /**
     * post请求
     *
     * @param head           请求头
     * @param requestUrl     链接地址
     * @param nameValuePairs 参数
     * @return 返回的json.toString()
     */
    public static String postRequest(Map<String, String> head, String requestUrl, NameValuePair[] nameValuePairs) {
        String response = null;
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(requestUrl);

        client.getParams().setContentCharset("UTF-8");
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        if (head.size() != 0) {
            for (String key : head.keySet()) {
                post.setRequestHeader(key, head.get(key));
            }
        }
        try {

            post.setRequestBody(nameValuePairs);
            client.executeMethod(post);
            response = post.getResponseBodyAsString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }
        return response;
    }

    /**
     * 获取post请求的参数
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getParam(HttpServletRequest request) throws Exception {

        StringBuffer data = new StringBuffer();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            while (null != (line = reader.readLine()))
                data.append(line);
        } catch (IOException e) {
            return null;
        }
        return data.toString();
    }
}
