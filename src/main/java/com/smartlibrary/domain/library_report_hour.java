package com.smartlibrary.domain;

/**
 * Created by tt on 2017/11/13.
 */
public class library_report_hour {
    int id;
    String school;
    int year;
    int month;
    int hour;
    int gctrl;//进馆次数
    int lend_people;//借阅次数
    int back_people;//还书次数
    int renew_people;//续借次数
    int lend;//借阅册数
    int back;//还书册数
    int renew;//续借册数
    int prints;//自助文印次数
    int print;//自助打印次数
    int copy;//自助复印次数
    int scan;//自主扫描次数
    int seats;//座位使用次数
    int crooms;//研修间使用次数
    int ereads;//电子阅览室次数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getGctrl() {
        return gctrl;
    }

    public void setGctrl(int gctrl) {
        this.gctrl = gctrl;
    }

    public int getLend_people() {
        return lend_people;
    }

    public void setLend_people(int lend_people) {
        this.lend_people = lend_people;
    }

    public int getBack_people() {
        return back_people;
    }

    public void setBack_people(int back_people) {
        this.back_people = back_people;
    }

    public int getRenew_people() {
        return renew_people;
    }

    public void setRenew_people(int renew_people) {
        this.renew_people = renew_people;
    }

    public int getLend() {
        return lend;
    }

    public void setLend(int lend) {
        this.lend = lend;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int getRenew() {
        return renew;
    }

    public void setRenew(int renew) {
        this.renew = renew;
    }

    public int getPrints() {
        return prints;
    }

    public void setPrints(int prints) {
        this.prints = prints;
    }

    public int getPrint() {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public int getScan() {
        return scan;
    }

    public void setScan(int scan) {
        this.scan = scan;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCrooms() {
        return crooms;
    }

    public void setCrooms(int crooms) {
        this.crooms = crooms;
    }

    public int getEreads() {
        return ereads;
    }

    public void setEreads(int ereads) {
        this.ereads = ereads;
    }
}
