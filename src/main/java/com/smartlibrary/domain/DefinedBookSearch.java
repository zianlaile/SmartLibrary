package com.smartlibrary.domain;

import com.smartlibrary.dao.definedContentConvertDao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;

public class DefinedBookSearch implements Serializable {

    @NotNull
    String timeSection;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String start_time;
    @NotNull @DateTimeFormat(pattern = "yyyy/MM/dd")
    String end_time;

    String academy;
    String[] academyList;

    String student_style;
    String[] student_styleList;

    String student_sex;

    String publisher;
    String[] publisherList;

    String book_style;
    String[] book_styleList;
    //0,1,2
    String lend_style;
    String[] lend_styleList;

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
        academyList=academy.split(",");
        this.academy = academy;
    }

    public String[] getAcademyList() {
        return academyList;
    }

    public void setAcademyList(String[] academyList) {
        this.academyList = academyList;
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
        publisherList=publisher.split(",");
        this.publisher = publisher;
    }

    public String[] getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(String[] publisherList) {
        this.publisherList = publisherList;
    }

    public String getBook_style() {
        return book_style;
    }

    public void setBook_style(String book_style) {
        book_styleList=book_style.split(",");
        this.book_style = book_style;
    }

    public String[] getBook_styleList() {
        return book_styleList;
    }

    public void setBook_styleList(String[] book_styleList) {
        this.book_styleList = book_styleList;
    }

    public String getLend_style() {
        return lend_style;
    }

    public void setLend_style(String lend_style) {
        lend_styleList=lend_style.split(",");
        this.lend_style = lend_style;
    }

    public String[] getLend_styleList() {
        return lend_styleList;
    }

    public void setLend_styleList(String[] lend_styleList) {
        this.lend_styleList = lend_styleList;
    }

    @Override
    public String toString() {
        return "DefinedBookSearch{" +
                "timeSection='" + timeSection + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", academy='" + academy + '\'' +
                ", academyList=" + Arrays.toString(academyList) +
                ", student_style='" + student_style + '\'' +
                ", student_styleList=" + Arrays.toString(student_styleList) +
                ", student_sex='" + student_sex + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisherList=" + Arrays.toString(publisherList) +
                ", book_style='" + book_style + '\'' +
                ", book_styleList=" + Arrays.toString(book_styleList) +
                ", lend_style='" + lend_style + '\'' +
                ", lend_styleList=" + Arrays.toString(lend_styleList) +
                '}';
    }

    public String getSearchContentSubTitle(definedContentConvertDao definedContentConvertDao){
        String title=getContent(timeSection,"时间")+getContent(academy,"学院")+getContent(student_style,"学生类别")
                +getContentofSex(student_sex,"性别")+getContent(publisher,"出版社")
                +getContentofConvert(book_styleList,"图书种类",definedContentConvertDao);
        if(lend_style==null||lend_style.trim().equals("")||lend_style.trim().equals("所有"))
            title+="借书还书续借";
        else{
            for(int i=0;i<lend_styleList.length;i++){
                if(lend_styleList[i].trim().equals("0"))
                    title+="借书";
                if(lend_styleList[i].trim().equals("1"))
                    title+="还书";
                if(lend_styleList[i].trim().equals("2"))
                    title+="续借";
            }
        }
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

    private String getContentofConvert(String[] s,String tip,definedContentConvertDao definedContentConvertDao){
        if(s!=null&&s.length!=0)
            return tip+":"+String.join(",", definedContentConvertDao.getDefinedContentName(s)).trim()+" ";
        else
            return "所有"+tip+" ";
    }
}
