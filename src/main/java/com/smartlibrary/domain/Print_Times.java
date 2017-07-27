package com.smartlibrary.domain;

/**
 * Created by 胡云飞 on 2017/7/21.
 */
public class Print_Times extends BaseObject{
    private int year;
    private int month;
    private int day;
    private int print_times;
    private String time;
    private String paper_type;
    private int counts;
    private String location;
    private int money;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPaper_type() {
        return paper_type;
    }

    public void setPaper_type(String paper_type) {
        this.paper_type = paper_type;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
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

    public int getPrint_times() {
        return print_times;
    }

    public void setPrint_times(int print_times) {
        this.print_times = print_times;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
