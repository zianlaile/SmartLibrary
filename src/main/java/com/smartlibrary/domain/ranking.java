package com.smartlibrary.domain;

/**
 * Created by tt on 2017/12/4.
 */
public class ranking {
    int id;
    int year;
    int month;
    int day;
    String ymdchar;
    String school;
    String academy;
    String account;
    String name;
    String book_name;
    int lend_times;
    int gctrl_times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getYmdchar() {
        return ymdchar;
    }

    public void setYmdchar(String ymdchar) {
        this.ymdchar = ymdchar;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getLend_times() {
        return lend_times;
    }

    public void setLend_times(int lend_times) {
        this.lend_times = lend_times;
    }

    public int getGctrl_times() {
        return gctrl_times;
    }

    public void setGctrl_times(int gctrl_times) {
        this.gctrl_times = gctrl_times;
    }
}
