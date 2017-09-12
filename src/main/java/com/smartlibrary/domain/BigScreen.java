package com.smartlibrary.domain;

/**
 * Created by 胡云飞 on 2017/9/11.
 */
public class BigScreen extends BaseObject{
    private String name;
    private String count;
    private String hour;
    private String lend;
    private String gctrl;
    private String print;
    private String seats;
    private String crooms;
    private String ereads;

    public String getGctrl() {
        return gctrl;
    }

    public void setGctrl(String gctrl) {
        this.gctrl = gctrl;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getCrooms() {
        return crooms;
    }

    public void setCrooms(String crooms) {
        this.crooms = crooms;
    }

    public String getEreads() {
        return ereads;
    }

    public void setEreads(String ereads) {
        this.ereads = ereads;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getLend() {
        return lend;
    }

    public void setLend(String lend) {
        this.lend = lend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
