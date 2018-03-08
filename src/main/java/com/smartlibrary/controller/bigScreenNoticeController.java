package com.smartlibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartlibrary.domain2.app_notice;
import com.smartlibrary.service.bigScreenNoticeService;
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
 * Created by tt on 2017/10/18.
 */
@Controller
@RequestMapping({ "/bigscreennotice" })
public class bigScreenNoticeController {
    @Autowired
    private bigScreenNoticeService bigscreennoticeservice;
    @RequestMapping(value = "/ShowList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> ShowList(HttpServletRequest request, @RequestBody JSONObject jsonObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        int pageSize = jsonObj.getInteger("pageSize"); //一页多少数据
        int offset = jsonObj.getInteger("offset");  //从第几条数据开始查
        int begin= offset;
        app_notice r = new app_notice();
        r.setOffset(offset);
        r.setPageSize(pageSize);
        List<app_notice> datalist  = bigscreennoticeservice.ShowList(r);
        int count=bigscreennoticeservice.Count(r);
        map.put("rows",datalist);
        map.put("total",count);
        map.put("prepage",offset);
        return map;
    }
    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public @ResponseBody
    boolean addorupdate(HttpServletRequest request, @RequestBody app_notice adddate) {
        if(0==adddate.getId())
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            adddate.setTime(df.format(new Date()));
            bigscreennoticeservice.add(adddate);}
        else{
          /*  System.out.println(adddate.getScreen_type());*/
            bigscreennoticeservice.update(adddate);}
        return true;
    }

    @RequestMapping(value = "/deleteByids", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteByids(HttpServletRequest request, @RequestBody ArrayList<Integer> ids) {
        bigscreennoticeservice.deletebyids(ids);
        return true;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public @ResponseBody
    app_notice getbyid(HttpServletRequest request, @RequestBody int id) {
        app_notice result=bigscreennoticeservice.getbyid(id);
        return result;
    }
//获取最新一条可用
    @RequestMapping(value = "/getnew", method = RequestMethod.GET)
    @ResponseBody
    public Map getnew(int screen_type) {
        Map res = new HashMap();
        System.out.println(screen_type);
        app_notice result=bigscreennoticeservice.getnew(screen_type);
        res.put("picurl",result.getPic_url());
        res.put("content",result.getContent());
        res.put("changtime",result.getTitle());
        res.put("status",result.getStatus());
        return res;
    }

    @RequestMapping(value = "/uploadpic")
    @ResponseBody
    public Map<String, Object> uploadpic(HttpServletRequest request, HttpServletResponse response, @RequestParam("pic_url") MultipartFile File, @RequestParam("id") int id) throws UnsupportedEncodingException {
        Map<String, Object> json = new HashMap<String, Object>();//上传后的返回信息
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
            java.io.File file = new File(url);
            if(!file.exists()){
                file.mkdirs();//创建文件夹
            }
            myFile.transferTo(new File(url));
            String url2 = "smartlib_app/"+name+"."+ext;
            app_notice n=new  app_notice();
            n.setId(id);
            n.setPic_url(url2);
            bigscreennoticeservice.updaten_picurl(n);
            json.put("success", ""+myFile.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json ;
    }
}
