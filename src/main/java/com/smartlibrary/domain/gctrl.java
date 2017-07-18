package com.smartlibrary.domain;

/**
 * Created by tt on 2017/7/18.
 */
public class gctrl extends BaseObject{
    int year;
    int month;
    int day;
    int hour;
    String time;//将年月日相连
    int gctrl_times; 

    public int getGctrl_times() {
        return gctrl_times;
    }

    public void setGctrl_times(int gctrl_times) {
        this.gctrl_times = gctrl_times;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
