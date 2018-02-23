package com.smartlibrary.domain;

import java.io.Serializable;
import java.sql.Date;

public class DefinedResult implements Serializable {

    String time="2017/1/1";  //时间（yyyy/mm/dd-yyyy/mm/dd）

    int amount=0;  //数量

    String academy=""; //学院

    String x_data="";

    Date operation_time;
    int year=0;
    int month=0;
    int day=0;


    public DefinedResult() {
    }

    public DefinedResult(String time, int amount) {
        this.time = time;
        this.amount = amount;
    }

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

    public Date getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getX_data() {
        return x_data;
    }

    public void setX_data(String x_data) {
        this.x_data = x_data;
    }

    @Override
    public String toString() {
        return "DefinedResult{" +
                "time='" + time + '\'' +
                ", amount=" + amount +
                ", academy='" + academy + '\'' +
                ", x_data='" + x_data + '\'' +
                ", operation_time=" + operation_time +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
