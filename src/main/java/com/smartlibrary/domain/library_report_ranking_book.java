package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/17.
 */
public class library_report_ranking_book {
    int id;
    String book_name;
    String author;
    String book_pubyear;
    String book_publisher;
    int lend_times;
    int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_pubyear() {
        return book_pubyear;
    }

    public void setBook_pubyear(String book_pubyear) {
        this.book_pubyear = book_pubyear;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public int getLend_times() {
        return lend_times;
    }

    public void setLend_times(int lend_times) {
        this.lend_times = lend_times;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
