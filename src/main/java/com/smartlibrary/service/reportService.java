package com.smartlibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.smartlibrary.common.CustomXWPFDocument;
import com.smartlibrary.common.Interface_processing;
import com.smartlibrary.common.WordUtil;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

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
        JSONArray section1_2_1 = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getGctrlsCountBy_year");
        JSONArray section1_2_2 = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getGctrlsCountBy_month");
        JSONArray section2_2_1 = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getBookkindAllCount_Byyear");
        JSONArray section2_3 = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getReder_booklendCount_Byyear");
        JSONArray section2_4 = interface_processing.return_json("http://localhost:8080/SmartLibrary/schoolReport/getop20authorBy_year");
        TreeSet<String> max_tree = new TreeSet<String>();
        int max = 0;
        for(int i=0;i<section1_2_1.size();i++){
            max_tree.add(section1_2_1.getJSONObject(i).getString("year"));
            if(i>0){
                if(Integer.valueOf(section1_2_1.getJSONObject(i).getString("gctrls"))>Integer.valueOf(section1_2_1.getJSONObject(i-1).getString("gctrls"))){
                    max = i;
                }
            }
        }
        param.put("${gctrl_year1}",max_tree.first());
        param.put("${gctrl_year2}",max_tree.last());
        param.put("${gctrl_year3}",section1_2_1.getJSONObject(max).getString("year"));
        param.put("${gctrl_amount}",section1_2_1.getJSONObject(max).getString("gctrls"));
        int sum_section1_2_2 = 0;
        int max_section1_2_2 = 0;
        for(int i=0;i<section1_2_2.size();i++){
            sum_section1_2_2+=section1_2_2.getJSONObject(i).getInteger("gctrl_times");
            if(i>0){
                if(section1_2_2.getJSONObject(i).getInteger("gctrl_times")>section1_2_2.getJSONObject(i-1).getInteger("gctrl_times")){
                    max_section1_2_2 = i;
                }
            }
        }
        param.put("${gctrl_month_year1}",section1_2_2.getJSONObject(0).getString("year"));
        param.put("${gctrl_month_month1}",section1_2_2.getJSONObject(0).getString("month"));
        param.put("${gctrl_month_year2}",section1_2_2.getJSONObject(section1_2_2.size()-1).getString("year"));
        param.put("${gctrl_month_month2}",section1_2_2.getJSONObject(section1_2_2.size()-1).getString("month"));
        param.put("${gctrl_month_amount}",String.valueOf(sum_section1_2_2));
        param.put("${gctrl_month_month3}",section1_2_2.getJSONObject(max_section1_2_2).getString("month"));
        param.put("${img_title_year}",section1_2_2.getJSONObject(0).getString("year"));
        ArrayList<Integer> array2_2_1 = new ArrayList<Integer>();
        for(int i=0;i<section2_2_1.size();i++){
            array2_2_1.add(section2_2_1.getJSONObject(i).getInteger("book_lend_times"));
        }
        ArrayList<Integer> array2_2_1_sort =array2_2_1;
        Collections.sort(array2_2_1_sort);
        int max2_2_1 = Collections.max(array2_2_1);
        int secondmax2_2_1 = array2_2_1_sort.get(array2_2_1_sort.size()-2);
        param.put("${lend_book_year}",section2_2_1.getJSONObject(0).getString("year"));
        param.put("${lend_book_type1}",section2_2_1.getJSONObject(array2_2_1.indexOf(max2_2_1)).getString("book_kind"));
        param.put("${lend_book_time1}",String.valueOf(max2_2_1));
        param.put("${lend_book_type2}",section2_2_1.getJSONObject(array2_2_1.indexOf(secondmax2_2_1)).getString("book_kind"));
        param.put("${lend_book_time2}",String.valueOf(secondmax2_2_1));
        param.put("${img_type_year}",section2_2_1.getJSONObject(0).getString("year"));
        param.put("${lend_reader_year1}",section2_3.getJSONObject(0).getString("year"));
        param.put("${lend_reader_name1}",section2_3.getJSONObject(0).getString("name"));
        param.put("${lend_reader_name2}",section2_3.getJSONObject(1).getString("name"));
        param.put("${lend_reader_name3}",section2_3.getJSONObject(2).getString("name"));
        param.put("${lend_reader_times1}",section2_3.getJSONObject(0).getString("all_lend_times"));
        param.put("${lend_reader_times2}",section2_3.getJSONObject(1).getString("all_lend_times"));
        param.put("${lend_reader_times3}",section2_3.getJSONObject(2).getString("all_lend_times"));
        for(int i=0;i<10;i++){
            int number = i+1;
            param.put("${1-"+number+"-1}",section2_3.getJSONObject(i).getString("account"));
            param.put("${1-"+number+"-2}",section2_3.getJSONObject(i).getString("name"));
            param.put("${1-"+number+"-3}",section2_3.getJSONObject(i).getString("academy"));
            param.put("${1-"+number+"-4}",section2_3.getJSONObject(i).getString("all_lend_times"));
        }
        param.put("${form_top10_year}",section2_3.getJSONObject(0).getString("year"));
        param.put("${top_book_name}",section2_4.getJSONObject(0).getString("book_name"));
        param.put("${top_book_times}",section2_4.getJSONObject(0).getString("lend_times"));
        param.put("${form_numbertop15_year}",section2_4.getJSONObject(0).getString("year"));
        for(int i=0;i<15;i++){
            int number = i+1;
            param.put("${2-"+number+"-1}",section2_4.getJSONObject(i).getString("book_name"));
            param.put("${2-"+number+"-2}",section2_4.getJSONObject(i).getString("author"));
            param.put("${2-"+number+"-3}",section2_4.getJSONObject(i).getString("book_pubyear"));
            param.put("${2-"+number+"-4}",section2_4.getJSONObject(i).getString("lend_times"));
        }
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
