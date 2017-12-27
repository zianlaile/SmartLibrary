package com.smartlibrary.common;

import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 胡云飞 on 2017/11/16.
 */
public class Picture {
    public Map<String,Object> returnpicture(String picBase64Info,String name){
        String path = this.getClass().getClassLoader().getResource("/").getPath();
        path = path.substring(0,path.indexOf("WEB-INF"))+"report/";
        System.out.println(path);
        String picpath = path + "reportpic";
        picpath = URLDecoder.decode(picpath);
        File f = new File(picpath);
        if(!f.exists()){
            //System.out.println("1不存在");
            f.mkdir();
        }
        picpath = picpath +"/"+name+".jpg"; //生成随机名字，避免重复
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
        Map<String,Object> header = new HashMap<String, Object>();
        return header;
    }
}
