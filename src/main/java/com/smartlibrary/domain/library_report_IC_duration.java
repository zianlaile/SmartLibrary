package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/17.
 */
public class library_report_IC_duration {
    int id;
    String ic_type;
    int lessone;
    int onetotwo;
    int twotofive;
    int morefive;
    int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIc_type() {
        return ic_type;
    }

    public void setIc_type(String ic_type) {
        this.ic_type = ic_type;
    }

    public int getLessone() {
        return lessone;
    }

    public void setLessone(int lessone) {
        this.lessone = lessone;
    }

    public int getOnetotwo() {
        return onetotwo;
    }

    public void setOnetotwo(int onetotwo) {
        this.onetotwo = onetotwo;
    }

    public int getTwotofive() {
        return twotofive;
    }

    public void setTwotofive(int twotofive) {
        this.twotofive = twotofive;
    }

    public int getMorefive() {
        return morefive;
    }

    public void setMorefive(int morefive) {
        this.morefive = morefive;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
