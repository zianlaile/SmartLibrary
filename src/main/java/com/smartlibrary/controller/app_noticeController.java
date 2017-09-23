package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_notice;
import com.smartlibrary.service.app_noticeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tt on 2017/9/23.
 */
@Controller
@RequestMapping({ "/notice" })
public class app_noticeController {
    @Autowired
    private app_noticeService noticeservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_notice n = new app_notice();
        n.setOffset(offset);
        n.setPageSize(pageSize);
        List<app_notice> datalist  = noticeservice.ShowList(n);
        int count=noticeservice.Count(n);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdaten", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdatebs(HttpServletRequest request, @RequestBody app_notice adddate) {
        if(0==adddate.getId())
        {noticeservice.addn(adddate);}
        else{noticeservice.updaten(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        noticeservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getnbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_notice getbsbyid(HttpServletRequest request, @RequestBody int id) {
        app_notice result=noticeservice.getnbyid(id);
        return result;
    }


    @RequestMapping(value = "/uploadpic")
    @ResponseBody
    public Map<String, Object> uploadpic(HttpServletRequest request, HttpServletResponse response, @RequestParam("pic_url") MultipartFile File,@RequestParam("id") int id) throws UnsupportedEncodingException {
        Map<String, Object> json = new HashMap<String, Object>();//上传后的返回信息
        System.out.println(id);
        MultipartFile myFile=File;
            try {
                //1
                //输出文件名称
                String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
                //2
                //图片存储名称名称
                DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String name = df.format(new Date());
                Random r = new Random();
                for(int i = 0 ;i<3 ;i++){
                    name += r.nextInt(10);//10以内随机数
                }
                String url = "c:/smartlib_app/notice/"+name+"."+ext;
                File file = new File(url);
                if(!file.exists()){
                    file.mkdirs();//创建文件夹
                }
                myFile.transferTo(new File(url));
                json.put("success", ""+myFile.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return json ;
    }
}
