package com.smartlibrary.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/11/16.
 */
public class Interface_processing {
    public JSONArray return_json(String urlName){
        Map data = new HashMap<String,String>();
        String result = "";
        //String urlName = "http://10.11.35.69/appinterface/RoomTotalInfo.aspx";
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                System.out.println(s + "-->" + map.get(s));
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray js = JSON.parseArray(result);
        return js;
    }
    public JSONObject return_jsonobject(String urlName){
        Map data = new HashMap<String,String>();
        String result = "";
        //String urlName = "http://10.11.35.69/appinterface/RoomTotalInfo.aspx";
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                System.out.println(s + "-->" + map.get(s));
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        JSONObject js = JSON.parseObject(result);
        return js;
    }
}
