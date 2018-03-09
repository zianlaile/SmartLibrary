package com.smartlibrary.domain;

public class MonthCrossAnalysis {
    int month;
    int book_lend_times;   //借阅次数
    int croom_times;       //研修间
    int eread_times;       //电子阅览室
    int seat_times;        //座位
    int print_times;       //打印
    int gctrl_times;       //进馆

    public int getMonth() { return month; }

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
}
