package com.thinkgem.jeesite.common.utils.wx;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
/**
 * @ClassName HttpClientUtil
 * @Description TODO
 * @Author TuTu
 * @Date 2020/5/27 20:04
 * @Version 1.0
 */
public class HttpClientUtil {

    @Autowired
    private CloseableHttpClient httpClient;

    public String doGet(String url, Map<String, String> param) {

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpClient.execute(httpGet);
//			logger.info(response.getStatusLine());
            // 判断返回状是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//				logger.info(resultString);
            }
        } catch(ConnectTimeoutException e){
            //请求超时
            return "ConnectTimeout";
        } catch(SocketTimeoutException  e){
            //响应超时
            return "SocketTimeout";
        } catch (Exception e) {
            e.printStackTrace();
            return "AllException";
        }
        finally {

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "IoException";
            }
        }
        return resultString;
    }

    public String doGet(String url) {
        return doGet(url, null);
    }

    public String doPost(String url, Map<String, String> param) {

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {

                final StringEntity sEntity = new StringEntity(param.toString());

                httpPost.setEntity(sEntity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
//			logger.info(response.getStatusLine());
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//			logger.info(resultString);
        } catch(ConnectTimeoutException e){
            //请求超时
            return "ConnectTimeout";
        } catch(SocketTimeoutException  e){
            //响应超时
            return "SocketTimeout";
        } catch (Exception e) {
            e.printStackTrace();
            return "AllException";
        }
        finally {

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "IoException";
            }
        }

        return resultString;
    }

    public String doPost(String url) throws Exception{
        return doPost(url, null);
    }

    public String doPostJson(String url, String json) {

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求

            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json,Charset.forName("utf-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
//			logger.info(response.getStatusLine());
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//			logger.info(resultString);
        } catch(ConnectTimeoutException e){
            //请求超时
            return "ConnectTimeout";
        } catch(SocketTimeoutException  e){
            //响应超时
            return "SocketTimeout";
        } catch (Exception e) {
            e.printStackTrace();
            return "AllException";
        }
        finally {

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "IoException";
            }
        }

        return resultString;
    }

    public String doPut(String url) {
        return doPutJson(url, null);
    }
    public String doPutJson(String url, String json) {

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPut httpPut = new HttpPut(url);
            if(null!=json){
                // 创建请求内容
                StringEntity entity = new StringEntity(json,Charset.forName("utf-8"));
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPut.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPut);
//			logger.info(response.getStatusLine());
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//			logger.info(resultString);
        } catch(ConnectTimeoutException e){
            //请求超时
            return "ConnectTimeout";
        } catch(SocketTimeoutException  e){
            //响应超时
            return "SocketTimeout";
        } catch (Exception e) {
            e.printStackTrace();
            return "AllException";
        }
        finally {

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "IoException";
            }
        }

        return resultString;
    }


    public String doDelete(String url) {
        return doDeleteJson(url, null);
    }
    public String doDeleteJson(String url, String json) {

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpDelete httpDelete = new HttpDelete(url);
            if(json != null ){
                // 创建请求内容
                StringEntity entity = new StringEntity(json);
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                ((HttpResponse) httpDelete).setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpDelete);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//			logger.info(resultString);
        } catch(ConnectTimeoutException e){
            //请求超时
            return "ConnectTimeout";
        } catch(SocketTimeoutException  e){
            //响应超时
            return "SocketTimeout";
        } catch (Exception e) {
            e.printStackTrace();
            return "AllException";
        }
        finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "IoException";
            }
        }
        return resultString;
    }
}
