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
    int  amount;
    int amounttype;
    int amountnumber;

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
