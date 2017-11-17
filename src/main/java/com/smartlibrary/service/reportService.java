package com.smartlibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.smartlibrary.common.CustomXWPFDocument;
import com.smartlibrary.common.Interface_processing;
import com.smartlibrary.common.WordUtil;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by 胡云飞 on 2017/11/1.
 */
@Service
public class reportService {
    public String getReport(String picBase64Info){
        Interface_processing interface_processing = new Interface_processing();
        String path = this.getClass().getClassLoader().getResource("/").getPath();
        path = path.substring(0,path.indexOf("WEB-INF"))+"report/";
        System.out.println(path);
        String wordpath = path + "88.docx";
        String towordpath = path + "2.docx";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("${school}", "浙江工业");
        JSONArray a = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getGctrlsCountBy_year");
        TreeSet<String> b = new TreeSet<String>();
        int max = 0;
        for(int i=0;i<a.size();i++){
            b.add(a.getJSONObject(i).getString("year"));
            if(i>0){
                if(Integer.valueOf(a.getJSONObject(i).getString("gctrls"))>Integer.valueOf(a.getJSONObject(i-1).getString("gctrls"))){
                    max = i;
                }
            }
        }
        param.put("${gctrl_year1}",b.first());
        param.put("${gctrl_year2}",b.last());
        param.put("${gctrl_year3}",a.getJSONObject(max).getString("year"));
        param.put("${gctrl_amount}",a.getJSONObject(max).getString("gctrls"));
        CustomXWPFDocument doc = WordUtil.generateWord(param, wordpath);
        FileOutputStream fopts = null;
        try {
            fopts = new FileOutputStream(towordpath);
            doc.write(fopts);
            fopts.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "1";
    }
}
