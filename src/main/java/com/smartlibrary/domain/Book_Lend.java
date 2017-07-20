package com.smartlibrary.domain;

/**
 * Created by tt on 2017/7/17.
 * 图书借阅类
 */
public class Book_Lend extends BaseObject{
    int book_lend_times;
    int m_book_lend_times;
    int f_book_lend_times;
    int book_back_times;
    int book_return_times;
    int year;
    int month;
    int day;
    int hour;
    String time;//将年月日相连
    String academy;
    String book_kind;
    String publisher;
    Double book_lend_w;

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
}
