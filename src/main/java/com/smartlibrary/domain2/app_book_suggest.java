package com.smartlibrary.domain2;

import com.smartlibrary.domain.BaseObject;

/**
 * Created by tt on 2017/9/22.
 */
public class app_book_suggest extends BaseObject {
    int id;
    int school_id;
    String pub_people;
    String book;
    String publisher;
    String auther;
    String introduction;
    String time ;
    int pageSize;//一页多少数据
    int offset; //从第几条数据开始查

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getPub_people() {
        return pub_people;
    }

    public void setPub_people(String pub_people) {
        this.pub_people = pub_people;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
