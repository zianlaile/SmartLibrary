package com.smartlibrary.domain;

import com.smartlibrary.dao.definedContentConvertDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DefinedIcSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String student_style;
    String[] student_styleList;

    @NotNull
    String ic_type;  //ic空间类别
    String[] ic_typeList;

    @NotNull @Size(max=1,min=0)
    int style;  //0-时长,1-人次

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

    public String getStudent_style() {
        return student_style;
    }

    public void setStudent_style(String student_style) {
        student_styleList=student_style.split(",");
        this.student_style = student_style;
    }

    public String[] getStudent_styleList() {
        return student_styleList;
    }

    public void setStudent_styleList(String[] student_styleList) {
        this.student_styleList = student_styleList;
    }

    public String getIc_type() {
        ic_typeList=ic_type.split(",");
        return ic_type;
    }

    public void setIc_type(String ic_type) {
        this.ic_type = ic_type;
    }

    public String[] getIc_typeList() {
        return ic_typeList;
    }

    public void setIc_typeList(String[] ic_typeList) {
        this.ic_typeList = ic_typeList;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getSearchContentSubTitle(definedContentConvertDao definedContentConvertDao){
        String title=getContent(timeSection,"时间")+getContentofConvert(student_style,student_styleList,"学生类别",definedContentConvertDao);
        if(ic_type==null||ic_type.trim().equals("")||ic_type.trim().equals("所有"))
            title+="所有IC空间";
        else{
            title+="IC空间类别:";
            String temp="";
            for(int i=0;i<ic_typeList.length;i++){
                if(ic_typeList[i].trim().equals("0"))
                    temp+=",研修室";
                if(ic_typeList[i].trim().equals("1"))
                    temp+=",座位";
                if(ic_typeList[i].trim().equals("2"))
                    temp+=",电子阅览室";
                if(ic_typeList[i].trim().equals("3"))
                    temp+=",设备";
            }
            title+=temp.replaceFirst(",","")+" ";
        }

        if(style==0)
            title+=" 时长";
        else
            title+=" 人次";
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
            return tip+":"+String.join(",", definedContentConvertDao.getDefinedNameOfStudentStyleById(s)).trim()+" ";
        else
            return "所有"+tip+" ";
    }
}
