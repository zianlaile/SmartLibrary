package com.smartlibrary.domain;

/**
 * Created by tt on 2017/7/17.
 * 图书借阅类
 */
public class Book_Lend extends BaseObject{
    int book_lend_times;    // ------------------
    int m_book_lend_times;
    int f_book_lend_times;
    int book_back_times; //
    int book_return_times;
    int book_lend_people;   //图书借出人数
    int book_renew_times;
    int academy_people_count;
    int year;
    int month;
    int day;
    int hour;
    int categoryAmount;     //  各类统计

    String lend_percent;
    String ymddate;//借阅日期
    String reader_academy;       //  读者学院
    String book_category;        //  书本种类
    String time;//将年月日相连

    String identity;
    String academy;
    String book_kind;
    String publisher;   // ----------------------
    String  book_name;  // --------------------
    String book_author; //---------------------
    Double book_lend_w;


    public String getBook_author() { return book_author; }

    public void setBook_author(String book_author) { this.book_author = book_author; }

    public String getBook_name() { return book_name; }

    public void setBook_name(String book_name) {  this.book_name = book_name; }

    public int getCategoryAmount() {
        return categoryAmount;
    }

    public void setCategoryAmount(int categoryAmount) { this.categoryAmount = categoryAmount; }

    public String getReader_academy() {  return reader_academy;  }

    public String getBook_category() {  return book_category; }

    public void setBook_category(String book_category) { this.book_category = book_category; }

    public void setReader_academy(String reader_academy) {  this.reader_academy = reader_academy; }

    public Double getBook_lend_w() {
        return book_lend_w;
    }

    public void setBook_lend_w(Double book_lend_w) {
        this.book_lend_w = book_lend_w;
    }

    public int getM_book_lend_times() {
        return m_book_lend_times;
    }

    public void setM_book_lend_times(int m_book_lend_times) {
        this.m_book_lend_times = m_book_lend_times;
    }

    public int getF_book_lend_times() {
        return f_book_lend_times;
    }

    public void setF_book_lend_times(int f_book_lend_times) {
        this.f_book_lend_times = f_book_lend_times;
    }

    public int getBook_back_times() {
        return book_back_times;
    }

    public void setBook_back_times(int book_back_times) {
        this.book_back_times = book_back_times;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBook_kind() {
        return book_kind;
    }

    public void setBook_kind(String book_kind) {
        this.book_kind = book_kind;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBook_lend_times() {
        return book_lend_times;
    }

    public void setBook_lend_times(int book_lend_times) {
        this.book_lend_times = book_lend_times;
    }

    public int getBook_return_times() {
        return book_return_times;
    }

    public void setBook_return_times(int book_return_times) {
        this.book_return_times = book_return_times;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getBook_lend_people() { return book_lend_people; }

    public void setBook_lend_people(int book_lend_people) { this.book_lend_people = book_lend_people; }

    public String getYmddate() { return ymddate; }

    public void setYmddate(String ymddate) { this.ymddate = ymddate; }

    public int getBook_renew_times() { return book_renew_times; }

    public void setBook_renew_times(int book_renew_times) { this.book_renew_times = book_renew_times; }

    public int getAcademy_people_count() { return academy_people_count; }

    public void setAcademy_people_count(int academy_people_count) { this.academy_people_count = academy_people_count; }

    public String getLend_percent() { return lend_percent; }

    public void setLend_percent(String lend_percent) { this.lend_percent = lend_percent; }

    public String getIdentity() { return identity; }

    public void setIdentity(String identity) { this.identity = identity; }

}
