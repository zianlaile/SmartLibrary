package com.smartlibrary.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class DefinedIcSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;
    String student_style;

    @NotNull @Size(max=3,min=0)
    int ic_type;  //ic空间类别

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
        this.student_style = student_style;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getIc_type() {
        return ic_type;
    }

    public void setIc_type(int ic_type) {
        this.ic_type = ic_type;
    }

    @Override
    public String toString() {
        return "DefinedIcSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", student_style='" + student_style + '\'' +
                ", ic_type=" + ic_type +
                ", style=" + style +
                '}';
    }

    public String getSearchContentSubTitle(List<DefinedSearchContent> definedSearchContents){
        String title=getContent(timeSection,"时间")+getContentofStudent_style(student_style,"学生类别",definedSearchContents);
        title+="IC空间类别:";
        if(ic_type==0)
            title+="研修室 ";
        else if(ic_type==1)
            title+="座位 ";
        else if(ic_type==2)
            title+="电子阅览室 ";
        else
            title+="设备 ";

        if(style==0)
            title+="时长";
        else
            title+="人次";
        return title.trim();
    }

    private String getContent(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+s.trim()+" ";
        else
            return "所有"+tip+" ";
    }

    private String getContentofStudent_style(String s,String tip,List<DefinedSearchContent> definedSearchContents){
        if(s!=null&&!s.isEmpty()&&s.trim()!=""){
            for(int i=0;i<definedSearchContents.size();i++){
                if(definedSearchContents.get(i).getId().equals(s))
                    return tip+":"+definedSearchContents.get(i).getName().trim()+" ";
            }
            return tip+":"+s.trim()+" ";
        }
        else
            return "所有"+tip+" ";
    }
}
