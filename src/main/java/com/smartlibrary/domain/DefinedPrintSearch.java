package com.smartlibrary.domain;

import com.smartlibrary.dao.definedContentConvertDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DefinedPrintSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String print_type;
    String[] print_typeList;

    String print_location;
    String[] print_locationList;

    String paper_type;
    String[] paper_typeList;

    public String getTimeSection() {
        return timeSection;
    }

    public void setTimeSection(String timeSection) {
        this.timeSection = timeSection;
        this.start_time=timeSection.split("-")[0].trim().replace('/','-');
        this.end_time=timeSection.split("-")[1].trim().replace('/','-');
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPrint_type() {
        return print_type;
    }

    public void setPrint_type(String print_type) {
        print_typeList=print_type.split(",");
        this.print_type = print_type;
    }

    public String[] getPrint_typeList() {
        return print_typeList;
    }

    public void setPrint_typeList(String[] print_typeList) {
        this.print_typeList = print_typeList;
    }

    public String getPrint_location() {
        return print_location;
    }

    public void setPrint_location(String print_location) {
        print_locationList=print_location.split(",");
        this.print_location = print_location;
    }

    public String[] getPrint_locationList() {
        return print_locationList;
    }

    public void setPrint_locationList(String[] print_locationList) {
        this.print_locationList = print_locationList;
    }

    public String getPaper_type() {
        return paper_type;
    }

    public void setPaper_type(String paper_type) {
        paper_typeList=paper_type.split(",");
        this.paper_type = paper_type;
    }

    public String[] getPaper_typeList() {
        return paper_typeList;
    }

    public void setPaper_typeList(String[] paper_typeList) {
        this.paper_typeList = paper_typeList;
    }

    public String getSearchContentSubTitle(definedContentConvertDao definedContentConvertDao){
        String title=getContent(timeSection,"时间")+getContent(print_type,"文印类型")+getContent(print_location,"设备地点")+getContentofConvert(paper_type,paper_typeList,"纸张类型",definedContentConvertDao);
        return title.trim();
    }

    private String getContent(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+s.trim()+" ";
        else
            return "所有"+tip+" ";
    }

    private String getContentofConvert(String str,String[] s,String tip,definedContentConvertDao definedContentConvertDao){
        if(str==null||str.isEmpty()||str.trim().equals("所有"))
            return "所有"+tip+" ";
        if(s!=null&&s.length!=0)
            return tip+":"+String.join(",", definedContentConvertDao.getDefinedNameOfPaperTypeById(s)).trim()+" ";
        else
            return "所有"+tip+" ";
    }

}
