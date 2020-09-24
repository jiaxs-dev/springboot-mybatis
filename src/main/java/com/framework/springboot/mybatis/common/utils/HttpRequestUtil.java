package com.framework.springboot.mybatis.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * request参数解析工具类
 */
public class HttpRequestUtil {

    public final static String CONTENTTYPE_JSON = "application/json";

    public static JSONObject parseRequestParams(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Map<String, String[]> dataMap = request.getParameterMap();// 参数列表
        if (dataMap != null && dataMap.size() > 0) {
            for (String key : dataMap.keySet()) {// 循环封装JSON对象
                if (dataMap.get(key).length == 1) {
                    jsonObject.put(key, dataMap.get(key)[0]);
                } else if (dataMap.get(key).length == 0) {
                    jsonObject.put(key, null);
                } else {
                    jsonObject.put(key, dataMap.get(key));
                }

            }
        }

        String body = HttpRequestUtil.getBodyString(request);
        String contentType = request.getContentType();
        if (contentType.equals(CONTENTTYPE_JSON)) {
            jsonObject.putAll(JSON.parseObject(body));
        }

        return jsonObject;
    }


    public static String toString(InputStream input, String encoding) throws IOException {
        byte[] bytes = new byte[0];
        bytes = new byte[input.available()];
        input.read(bytes);
        return new String(bytes, encoding);
    }

    public static String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
