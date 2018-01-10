package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/17.
 */
//  book_author,reader_identity,book_lend_times
public class library_report_ranking_book {
    int id;
    String book_name;
    String book_author;
    String book_pubyear;
    String book_publisher;
    String reader_identity;
    String book_category;
    String name;  // 图书种类的名称
    int book_lend_times;
    int year;


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBook_category() { return book_category; }

    public void setBook_category(String book_category) { this.book_category = book_category;}

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBook_author() { return book_author; }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getReader_identity() { return reader_identity; }

    public void setReader_identity(String reader_identity) { this.reader_identity = reader_identity; }

    public int getBook_lend_times() { return book_lend_times; }

    public void setBook_lend_times(int book_lend_times) { this.book_lend_times = book_lend_times; }
}
