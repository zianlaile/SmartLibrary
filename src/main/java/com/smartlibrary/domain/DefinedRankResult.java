package com.smartlibrary.domain;

public class DefinedRankResult extends DefinedResult {
    String author;
    String publisher;
    String ISBN;
    String publisher_time;

    String account;//学生账号

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher_time() {
        return publisher_time;
    }

    public void setPublisher_time(String publisher_time) {
        this.publisher_time = publisher_time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "DefinedRankResult{" +
                "author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher_time='" + publisher_time + '\'' +
                ", account='" + account + '\'' +
                ", time='" + time + '\'' +
                ", amount=" + amount +
                ", academy='" + academy + '\'' +
                ", x_data='" + x_data + '\'' +
                ", operation_time=" + operation_time +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
