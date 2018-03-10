package com.smartlibrary.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class DefinedBookSearch implements Serializable {

    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;
    String academy;
    String student_style;
    String student_sex;
    String publisher;
    String book_style;
    @NotNull @Size(max=2,min=0)
    int lend_style;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBook_style() {
        return book_style;
    }

    public void setBook_style(String book_style) {
        this.book_style = book_style;
    }

    public int getLend_style() {
        return lend_style;
    }

    public void setLend_style(int lend_style) {
        this.lend_style = lend_style;
    }

    @Override
    public String toString() {
        return "DefinedBookSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", academy='" + academy + '\'' +
                ", student_style='" + student_style + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", publisher='" + publisher + '\'' +
                ", book_style='" + book_style + '\'' +
                ", lend_style=" + lend_style +
                '}';
    }

    public String getSearchContentSubTitle(List<DefinedSearchContent> definedSearchContents){
        String title=getContent(timeSection,"时间")+getContent(academy,"学院")+getContent(student_style,"学生类别")
                +getContentofSex(student_sex,"性别")+getContent(publisher,"出版社")+getContentofBook_style(book_style,"图书种类",definedSearchContents);
        if(lend_style==0)
            title+="借书";
        else if(lend_style==1)
            title+="还书";
        else
            title+="续借";
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

    private String getContentofBook_style(String s,String tip,List<DefinedSearchContent> definedSearchContents){
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
