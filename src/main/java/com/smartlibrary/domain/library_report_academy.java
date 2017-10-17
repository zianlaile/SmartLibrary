package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/17.
 */
public class library_report_academy {
    int id;
    int  year;
    String academy;
    int lend;
    int back;
    int renew;
    int people_counts;
    double prelend;

    public double getPrelend() {
        return prelend;
    }

    public void setPrelend(double prelend) {
        this.prelend = prelend;
    }

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

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
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

    public int getPeople_counts() {
        return people_counts;
    }

    public void setPeople_counts(int people_counts) {
        this.people_counts = people_counts;
    }
}
