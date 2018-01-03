package com.smartlibrary.domain;

/**
 * Created by tt on 2017/11/13.
 */
public class library_report_month_mankinds {
    int id;
    String school;
    int year;
    int month;
    String man_kind;

    public String getIdentity() {
        return identity;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    String identity;
    int lend;
    int back;
    int renew;
    int gctrl;
    int sum;

// library_report_month_teacher
    String account;
    String name;
    String gender;

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

    public String getMan_kind() {
        return man_kind;
    }

    public void setMan_kind(String man_kind) {
        this.man_kind = man_kind;
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

    public int getGctrl() {
        return gctrl;
    }

    public void setGctrl(int gctrl) {
        this.gctrl = gctrl;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
