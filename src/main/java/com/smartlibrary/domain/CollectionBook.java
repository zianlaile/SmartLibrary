package com.smartlibrary.domain;

/**
 * Created by tt on 2017/12/20.
 */
public class CollectionBook {
    int id;
    String  year;
    String  stack;
    String category;
    String   bookType;
    String print_type;
    String  print_location;
    int times;
    int  amount;
    int amounttype;
    int amountnumber;

    public String getPrint_location() {
        return print_location;
    }

    public void setPrint_location(String print_location) {
        this.print_location = print_location;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getPrint_type() {
        return print_type;
    }

    public void setPrint_type(String print_type) {
        this.print_type = print_type;
    }

    public int getAmounttype() {
        return amounttype;
    }

    public void setAmounttype(int amounttype) {
        this.amounttype = amounttype;
    }

    public int getAmountnumber() {
        return amountnumber;
    }

    public void setAmountnumber(int amountnumber) {
        this.amountnumber = amountnumber;
    }


    int ZWTS;
    int ZWZS;
    int QT;
    int WKHDB;
    int WWTS;
    int XWLW;
    int GTTS;
    int TCTS;

    public int getZWTS() {
        return ZWTS;
    }

    public void setZWTS(int ZWTS) {
        this.ZWTS = ZWTS;
    }

    public int getZWZS() {
        return ZWZS;
    }

    public void setZWZS(int ZWZS) {
        this.ZWZS = ZWZS;
    }

    public int getQT() {
        return QT;
    }

    public void setQT(int QT) {
        this.QT = QT;
    }

    public int getWKHDB() {
        return WKHDB;
    }

    public void setWKHDB(int WKHDB) {
        this.WKHDB = WKHDB;
    }

    public int getWWTS() {
        return WWTS;
    }

    public void setWWTS(int WWTS) {
        this.WWTS = WWTS;
    }

    public int getXWLW() {
        return XWLW;
    }

    public void setXWLW(int XWLW) {
        this.XWLW = XWLW;
    }

    public int getGTTS() {
        return GTTS;
    }

    public void setGTTS(int GTTS) {
        this.GTTS = GTTS;
    }

    public int getTCTS() {
        return TCTS;
    }

    public void setTCTS(int TCTS) {
        this.TCTS = TCTS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
