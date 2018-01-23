package com.smartlibrary.domain;

import java.io.Serializable;

public class DefinedBookResult implements Serializable {

    String time;  //时间（yyyy/mm/dd-yyyy/mm/dd）

    int amount;  //数量
    int year;
    int month;
    int day;

    public void setTime(){
        time=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
}
