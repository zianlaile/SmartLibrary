package com.smartlibrary.domain;

/**
 * Created by tt on 2017/11/13.
 */
public class reader_report{
    int id;//id
    String account;//账户
    String name;//名字
    String gender;
    String school;//学校
    String academy;//学院
    String identity;//身份
    int year;//年份
    int crooms;//研究间时长
    int ereads;//电子阅览室时长
    int seats;//座位时长
    int lend;//借阅时长

    String first_gctr_date;//第一次进馆时间
    int all_gctrl_times;//累计进馆次数
    int all_gctrl_rank;//进馆次数排名
    String book_no;
    String longgest_book_name;//借阅时间最长的书名
    int longgest_book_days;//借阅时间最长的书的天数
    int all_lend_times;//借阅总量
    int all_lend_rank;//借阅总量排名

    String max_book_type;//借阅量最多的图书类别
    int max_book_type_count;//借阅量最多的图书类别的借阅量
    int max_book_year;//借阅量最多的年份
    int max_book_month;//借阅量最多的月份
    int max_book_month_count;//借阅量最多的月份的借阅量
    String max_print_date;//打印页数最多的日期
    int max_print_counts;//打印页数最多时的打印量

    int all_printcs_counts;//累计文印总量
    int all_printcs_rank;//累计文印总量排名
    int all_print_counts;//累计打印页数
    int all_copy_counts;//累计复印页数
    int all_scan_counts;//累计扫描页数

    String longgset_seat_date;//座位使用时间最长的日期
    int longgest_seat_hours;///座位使用时间最长的时间
    int all_seat_times;//座位使用总次数
    int all_seat_hours;//座位使用总时长

    String longgest_croom_date;//研修间使用时间最长的日期
    int longgest_croom_hours;//研修间使用时间最长的时间
    int all_croom_times;//研修间使用总次数
    int all_croom_hours;//研修间使用总时长

    String longgest_eread_date;//电子阅览室使用时间最长的日期
    int  longgest_eread_hours;//电子阅览室使用时间最长的时间
    int  all_eread_times;//电子阅览室使用总次数
    int all_eread_hours;//电子阅览室使用总时长
    int month_lend_rank;//借阅月总量排名
    int month_gctrl_rank;//借阅月量排名

    double per_gctrl_times;//进馆百分比

    public String getBook_no() {
        return book_no;
    }

    public void setBook_no(String book_no) {
        this.book_no = book_no;
    }
    public int getMonth_lend_rank() {
        return month_lend_rank;
    }

    public void setMonth_lend_rank(int month_lend_rank) {
        this.month_lend_rank = month_lend_rank;
    }

    public int getMonth_gctrl_rank() {
        return month_gctrl_rank;
    }

    public void setMonth_gctrl_rank(int month_gctrl_rank) {
        this.month_gctrl_rank = month_gctrl_rank;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPer_gctrl_times() {
        return per_gctrl_times;
    }

    public void setPer_gctrl_times(double per_gctrl_times) {
        this.per_gctrl_times = per_gctrl_times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCrooms() {
        return crooms;
    }

    public void setCrooms(int crooms) {
        this.crooms = crooms;
    }

    public int getEreads() {
        return ereads;
    }

    public void setEreads(int ereads) {
        this.ereads = ereads;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getLend() {
        return lend;
    }

    public void setLend(int lend) {
        this.lend = lend;
    }

    public String getFirst_gctr_date() {
        return first_gctr_date;
    }

    public void setFirst_gctr_date(String first_gctr_date) {
        this.first_gctr_date = first_gctr_date;
    }

    public int getAll_gctrl_times() {
        return all_gctrl_times;
    }

    public void setAll_gctrl_times(int all_gctrl_times) {
        this.all_gctrl_times = all_gctrl_times;
    }

    public int getAll_gctrl_rank() {
        return all_gctrl_rank;
    }

    public void setAll_gctrl_rank(int all_gctrl_rank) {
        this.all_gctrl_rank = all_gctrl_rank;
    }

    public int getAll_lend_times() {
        return all_lend_times;
    }

    public void setAll_lend_times(int all_lend_times) {
        this.all_lend_times = all_lend_times;
    }

    public int getAll_lend_rank() {
        return all_lend_rank;
    }

    public void setAll_lend_rank(int all_lend_rank) {
        this.all_lend_rank = all_lend_rank;
    }

    public String getMax_book_type() {
        return max_book_type;
    }

    public void setMax_book_type(String max_book_type) {
        this.max_book_type = max_book_type;
    }

    public int getMax_book_type_count() {
        return max_book_type_count;
    }

    public void setMax_book_type_count(int max_book_type_count) {
        this.max_book_type_count = max_book_type_count;
    }

    public int getMax_book_year() {
        return max_book_year;
    }

    public void setMax_book_year(int max_book_year) {
        this.max_book_year = max_book_year;
    }

    public int getMax_book_month() {
        return max_book_month;
    }

    public void setMax_book_month(int max_book_month) {
        this.max_book_month = max_book_month;
    }

    public int getMax_book_month_count() {
        return max_book_month_count;
    }

    public void setMax_book_month_count(int max_book_month_count) {
        this.max_book_month_count = max_book_month_count;
    }

    public String getMax_print_date() {
        return max_print_date;
    }

    public void setMax_print_date(String max_print_date) {
        this.max_print_date = max_print_date;
    }

    public int getMax_print_counts() {
        return max_print_counts;
    }

    public void setMax_print_counts(int max_print_counts) {
        this.max_print_counts = max_print_counts;
    }

    public int getAll_printcs_counts() {
        return all_printcs_counts;
    }

    public void setAll_printcs_counts(int all_printcs_counts) {
        this.all_printcs_counts = all_printcs_counts;
    }

    public int getAll_printcs_rank() {
        return all_printcs_rank;
    }

    public void setAll_printcs_rank(int all_printcs_rank) {
        this.all_printcs_rank = all_printcs_rank;
    }

    public int getAll_print_counts() {
        return all_print_counts;
    }

    public void setAll_print_counts(int all_print_counts) {
        this.all_print_counts = all_print_counts;
    }

    public int getAll_copy_counts() {
        return all_copy_counts;
    }

    public void setAll_copy_counts(int all_copy_counts) {
        this.all_copy_counts = all_copy_counts;
    }

    public int getAll_scan_counts() {
        return all_scan_counts;
    }

    public void setAll_scan_counts(int all_scan_counts) {
        this.all_scan_counts = all_scan_counts;
    }

    public String getLonggset_seat_date() {
        return longgset_seat_date;
    }

    public void setLonggset_seat_date(String longgset_seat_date) {
        this.longgset_seat_date = longgset_seat_date;
    }

    public int getLonggest_seat_hours() {
        return longgest_seat_hours;
    }

    public void setLonggest_seat_hours(int longgest_seat_hours) {
        this.longgest_seat_hours = longgest_seat_hours;
    }

    public int getAll_seat_times() {
        return all_seat_times;
    }

    public void setAll_seat_times(int all_seat_times) {
        this.all_seat_times = all_seat_times;
    }

    public int getAll_seat_hours() {
        return all_seat_hours;
    }

    public void setAll_seat_hours(int all_seat_hours) {
        this.all_seat_hours = all_seat_hours;
    }

    public String getLonggest_croom_date() {
        return longgest_croom_date;
    }

    public void setLonggest_croom_date(String longgest_croom_date) {
        this.longgest_croom_date = longgest_croom_date;
    }

    public int getLonggest_croom_hours() {
        return longgest_croom_hours;
    }

    public void setLonggest_croom_hours(int longgest_croom_hours) {
        this.longgest_croom_hours = longgest_croom_hours;
    }

    public int getAll_croom_times() {
        return all_croom_times;
    }

    public void setAll_croom_times(int all_croom_times) {
        this.all_croom_times = all_croom_times;
    }

    public int getAll_croom_hours() {
        return all_croom_hours;
    }

    public void setAll_croom_hours(int all_croom_hours) {
        this.all_croom_hours = all_croom_hours;
    }

    public String getLonggest_eread_date() {
        return longgest_eread_date;
    }

    public String getLonggest_book_name() {
        return longgest_book_name;
    }

    public int getLonggest_book_days() {
        return longgest_book_days;
    }

    public void setLonggest_book_name(String longgest_book_name) {
        this.longgest_book_name = longgest_book_name;

    }

    public void setLonggest_book_days(int longgest_book_days) {
        this.longgest_book_days = longgest_book_days;
    }

    public void setLonggest_eread_date(String longgest_eread_date) {
        this.longgest_eread_date = longgest_eread_date;
    }

    public int getLonggest_eread_hours() {
        return longgest_eread_hours;
    }

    public void setLonggest_eread_hours(int longgest_eread_hours) {
        this.longgest_eread_hours = longgest_eread_hours;
    }

    public int getAll_eread_times() {
        return all_eread_times;
    }

    public void setAll_eread_times(int all_eread_times) {
        this.all_eread_times = all_eread_times;
    }

    public int getAll_eread_hours() {
        return all_eread_hours;
    }

    public void setAll_eread_hours(int all_eread_hours) {
        this.all_eread_hours = all_eread_hours;
    }
}
