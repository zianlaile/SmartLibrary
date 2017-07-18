package com.smartlibrary.domain;

/**
 * Created by tt on 2017/7/17.
 * 图书借阅类
 */
public class Book_Lend extends BaseObject{
    int book_lend_times;
    int book_return_times;
    int year;
    int month;
    int day;
    int hour;
    String time;//将年月日相连

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
