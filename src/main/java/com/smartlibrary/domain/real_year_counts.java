package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/12.
 */
public class real_year_counts {
    int   id;
    int   year;
    int  gctrls;
    int  book_lend;
    int  book_renew;
    int   book_back;
    int  all_book;
    int  print;
    int  copy;
    int  scan;

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

    public int getGctrls() {
        return gctrls;
    }

    public void setGctrls(int gctrls) {
        this.gctrls = gctrls;
    }

    public int getBook_lend() {
        return book_lend;
    }

    public void setBook_lend(int book_lend) {
        this.book_lend = book_lend;
    }

    public int getBook_renew() {
        return book_renew;
    }

    public void setBook_renew(int book_renew) {
        this.book_renew = book_renew;
    }

    public int getBook_back() {
        return book_back;
    }

    public void setBook_back(int book_back) {
        this.book_back = book_back;
    }

    public int getAll_book() {
        return all_book;
    }

    public void setAll_book(int all_book) {
        this.all_book = all_book;
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
}
