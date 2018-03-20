package com.smartlibrary.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class DefinedRankSearch implements Serializable {
    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String academy;
    String student_style;
    String student_sex;

    String print_location;//设备地点
    String paper_type;//纸张类型
    String print_type;//文印类型

    int book_rank_type=0;//排行类别 0-图书借阅量,1-学生借阅量

    @NotNull
    int rank_number=10;//排行数量

    @NotNull @Size(max=2,min=0)
    int rank_style=0;  //0-借阅,1-进馆，2-打印复印

    public String getTimeSection() {
        return timeSection;
    }

    public void setTimeSection(String timeSection) {
        this.start_time=timeSection.split("-")[0].trim().replace('/','-');
        this.end_time=timeSection.split("-")[1].trim().replace('/','-');
        this.timeSection = timeSection;
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

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getStudent_style() {
        return student_style;
    }

    public void setStudent_style(String student_style) {
        this.student_style = student_style;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getPrint_location() {
        return print_location;
    }

    public void setPrint_location(String print_location) {
        this.print_location = print_location;
    }

    public String getPrint_type() {
        return print_type;
    }

    public void setPrint_type(String print_type) {
        this.print_type = print_type;
    }

    public String getPaper_type() {
        return paper_type;
    }

    public void setPaper_type(String paper_type) {
        this.paper_type = paper_type;
    }

    public int getBook_rank_type() {
        return book_rank_type;
    }

    public void setBook_rank_type(int book_rank_type) {
        this.book_rank_type = book_rank_type;
    }

    public int getRank_number() {
        return rank_number;
    }

    public void setRank_number(int rank_number) {
        this.rank_number = rank_number;
    }

    public int getRank_style() {
        return rank_style;
    }

    public void setRank_style(int rank_style) {
        this.rank_style = rank_style;
    }

    @Override
    public String toString() {
        return "DefinedRankSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", academy='" + academy + '\'' +
                ", student_style='" + student_style + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", print_location='" + print_location + '\'' +
                ", paper_type='" + paper_type + '\'' +
                ", print_type='" + print_type + '\'' +
                ", book_rank_type=" + book_rank_type +
                ", rank_number=" + rank_number +
                ", rank_style=" + rank_style +
                '}';
    }

    public String getSearchContentSubTitle(List<DefinedSearchContent> definedSearchContents){
        String title=getContent(timeSection,"时间");
        if(rank_style==0){
            title+="借阅 "+getContent(academy,"学院")+getContent(student_style,"学生类别")+getContentofSex(student_sex,"性别");
            if(book_rank_type==0)
                title+="排行种类:图书借阅量 ";
            else
                title+="排行种类:学生借阅量 ";
        }else if(rank_style==1){
            title+="进馆 "+getContent(academy,"学院")+getContent(student_style,"学生类别")+getContentofSex(student_sex,"性别");
        }else{
            title+="打印复印 "+getContent(print_type,"文印种类")+getContent(print_location,"设备地点").trim()+getContentofPaper_stype(paper_type,"纸张类型",definedSearchContents);
        }
        title+="排行前"+rank_number;
        return title.trim();
    }

    private String getContent(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+s.trim()+" ";
        else
            return "所有"+tip+" ";
    }

    private String getContentofSex(String s,String tip){
        if(s!=null&&!s.isEmpty()&&s.trim()!="")
            return tip+":"+(s.trim().equals("M")?"男":"女")+" ";
        else
            return "所有"+tip+" ";
    }

    private String getContentofPaper_stype(String s,String tip,List<DefinedSearchContent> definedSearchContents){
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
