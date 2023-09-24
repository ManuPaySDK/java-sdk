package com.cpt.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
    private static CloseableHttpClient httpClient;
    private static HttpUtil httpUtil;
    public  synchronized  static HttpUtil getInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    private HttpUtil() {
        //ClientConnectionManager connManager = new PoolingClientConnectionManager();
        httpClient = HttpClients.createDefault();
    }

    public String post(String url, String params) {
        HttpPost httpPost = new HttpPost(url);
        //post.setConfig(requestConfig);
       // httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET4.0C; .NET4.0E)");
        httpPost.setHeader("Accept", "*/*");
        //httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Accept-Language", "zh-CN");

        StringEntity paramsEntity = new StringEntity(params, "utf-8");
        paramsEntity.setContentType("application/json");
        httpPost.setEntity(paramsEntity);

        String result = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            result =  EntityUtils.toString(response.getEntity(), "utf-8");
        }catch (Exception e) {
            e.printStackTrace();
            //System.out.println("got response=" + e.));
        }
        return result;
    }
}
