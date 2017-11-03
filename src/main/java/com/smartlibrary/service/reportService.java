package com.smartlibrary.service;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/11/1.
 */
@Service
public class reportService {
    public String getReport(String picBase64Info){
        String path = this.getClass().getClassLoader().getResource("/").getPath();
        path = path.substring(0,path.indexOf("WEB-INF"))+"report/";
        System.out.println(path);
        String picpath = path + "reportpic";
        String wordpath = path + "1.docx";
        String towordpath = path + "2.docx";
        picpath = URLDecoder.decode(picpath);
        File f = new File(picpath);
        if(!f.exists()){
            //System.out.println("1不存在");
            f.mkdir();
        }
        picpath = picpath + "/1.jpg"; //生成随机名字，避免重复
        /*f = new File(path);
        if(!f.exists()){
            System.out.println("2不存在");
            f.mkdir();
        }*/
        BASE64Decoder decoder = new BASE64Decoder();
        String[] arr = picBase64Info.split("base64,");
        try {
            byte[] buffer = decoder.decodeBuffer(arr[1]);
            OutputStream os = new FileOutputStream(picpath);
            os.write(buffer);
            os.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("${name}", "二楼");
        Map<String,Object> header = new HashMap<String, Object>();
        header.put("width", 600);
        header.put("height", 400);
        header.put("type", "JPG");
        try {
            header.put("content", WordUtil.inputStream2ByteArray(new FileInputStream(picpath), true));
            System.out.println(header);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        param.put("${header}",header);
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
