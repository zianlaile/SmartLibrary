package com.smartlibrary.domain;

public class CrossAnalysis {
    int month;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    int hour;               //小时
    String  year;               //年份 (传参使用)
    int book_lend_times;    //借阅次数
    int book_lend_times_rank;// 借阅排名
    int croom_times;        //研修间
    int croom_times_rank;   //  研修间使用排名
    int eread_times;        //电子阅览室
    int eread_times_rank;   //电子阅览室使用排名
    int seat_times;         //座位
    int seat_times_rank;    //座位使用排名
    int print_times;        //打印
    int print_times_rank;   // 打印使用排名
    int gctrl_times;        //进馆
    int gctrl_times_rank;   // 进馆排名
    float day_use_account;  //日使用率
    float month_use_account;//月使用率
    float year_use_account; //年使用率
    int acdemy_stu_amount;  //学院人数
    float utlization_ratio; //利用率
    String ic_type;         //ic空间类型
    String academy;         //学院

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getBook_lend_times_rank() {
        return book_lend_times_rank;
    }

    public void setBook_lend_times_rank(int book_lend_times_rank) {
        this.book_lend_times_rank = book_lend_times_rank;
    }

    public int getCroom_times_rank() {
        return croom_times_rank;
    }

    public void setCroom_times_rank(int croom_times_rank) {
        this.croom_times_rank = croom_times_rank;
    }

    public int getEread_times_rank() {
        return eread_times_rank;
    }

    public void setEread_times_rank(int eread_times_rank) {
        this.eread_times_rank = eread_times_rank;
    }

    public int getSeat_times_rank() {
        return seat_times_rank;
    }

    public void setSeat_times_rank(int seat_times_rank) {
        this.seat_times_rank = seat_times_rank;
    }

    public int getPrint_times_rank() {
        return print_times_rank;
    }

    public void setPrint_times_rank(int print_times_rank) {
        this.print_times_rank = print_times_rank;
    }

    public int getGctrl_times_rank() {
        return gctrl_times_rank;
    }

    public void setGctrl_times_rank(int gctrl_times_rank) {
        this.gctrl_times_rank = gctrl_times_rank;
    }

    public int getAcdemy_stu_amount() {
        return acdemy_stu_amount;
    }

    public void setAcdemy_stu_amount(int acdemy_stu_amount) {
        this.acdemy_stu_amount = acdemy_stu_amount;
    }

    public float getDay_use_account() { return day_use_account; }

    public void setDay_use_account(float day_use_account) {
        this.day_use_account = day_use_account;
    }

    public float getMonth_use_account() {
        return month_use_account;
    }

    public void setMonth_use_account(float month_use_account) {
        this.month_use_account = month_use_account;
    }

    public float getYear_use_account() {
        return year_use_account;
    }

    public void setYear_use_account(float year_use_account) {
        this.year_use_account = year_use_account;
    }

    public String getIc_type() {
        return ic_type;
    }

    public void setIc_type(String ic_type) {
        this.ic_type = ic_type;
    }

    public int getMonth() { return month; }

    public float getUtlization_ratio() {
        return utlization_ratio;
    }

    public void setUtlization_ratio(float utlization_ratio) {
        this.utlization_ratio = utlization_ratio;
    }

    public void setMonth(int month) { this.month = month; }

    public int getBook_lend_times() { return book_lend_times; }

    public void setBook_lend_times(int book_lend_times) { this.book_lend_times = book_lend_times; }

    public int getCroom_times() { return croom_times; }

    public void setCroom_times(int croom_times) { this.croom_times = croom_times; }

    public int getEread_times() { return eread_times; }

    public void setEread_times(int eread_times) { this.eread_times = eread_times; }

    public int getSeat_times() { return seat_times; }

    public void setSeat_times(int seat_times) { this.seat_times = seat_times; }

    public int getPrint_times() { return print_times; }

    public void setPrint_times(int print_times) { this.print_times = print_times; }

    public int getGctrl_times() { return gctrl_times; }

    public void setGctrl_times(int gctrl_times) { this.gctrl_times = gctrl_times; }

    public String getAcademy() { return academy; }

    public void setAcademy(String academy) { this.academy = academy; }
}
