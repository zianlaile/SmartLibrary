package com.smartlibrary.domain;

import java.io.Serializable;

public class DefinedBookResult implements Serializable {

    String time="2017/1/1";  //时间（yyyy/mm/dd-yyyy/mm/dd）

    int amount=0;  //数量
    int year=0;
    int month=0;
    int day=0;

    public DefinedBookResult() {
    }

    public DefinedBookResult(String time, int amount) {
        this.time = time;
        this.amount = amount;
    }

    public void setTime(){
        time=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
    }

    public String getTime() {
        time=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
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

    @Override
    public String toString() {
        return "DefinedBookResult{" +
                "time='" + time + '\'' +
                ", amount=" + amount +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
