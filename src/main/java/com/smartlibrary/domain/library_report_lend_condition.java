package com.smartlibrary.domain;

public class library_report_lend_condition {
    String academy;
    String identity;
    int reader_number;
    int lend_number;
    int lend_total;
    int year;
    float reader_per_person;
    float academy_per_person;
    float percentage_of_borrowing;

    public String getIdentity() {return identity; }

    public void setIdentity(String identity) { this.identity = identity; }

    public int getReader_number() {return reader_number;}

    public void setReader_number(int reader_number) {this.reader_number = reader_number;}

    public int getLend_number() {return lend_number;}

    public void setLend_number(int lend_number) {this.lend_number = lend_number;}

    public int getLend_total() {return lend_total;}

    public void setLend_total(int lend_total) {this.lend_total = lend_total;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    public float getReader_per_person() {return reader_per_person;}

    public void setReader_per_person(float reader_per_person) {this.reader_per_person = reader_per_person;}

    public float getAcademy_per_person() {return academy_per_person;}

    public void setAcademy_per_person(float academy_per_person) {this.academy_per_person = academy_per_person;}

    public String getAcademy() { return academy;}

    public void setAcademy(String academy) { this.academy = academy; }

    public float getPercentage_of_borrowing() { return percentage_of_borrowing; }

    public void setPercentage_of_borrowing(float percentage_of_borrowing) {this.percentage_of_borrowing = percentage_of_borrowing;}
}
