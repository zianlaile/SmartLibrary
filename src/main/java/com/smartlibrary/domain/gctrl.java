package com.smartlibrary.domain;

/**
 * Created by tt on 2017/7/18.
 */
public class gctrl extends BaseObject{
    int year;
    int month;
    int day;
    int hour;
    String time;//将年月日相连
    int gctrl_times;
    String academy;//将年月日相连
    int undergraduate_times;
    int graduate_times;
    int teacher_times;
    int other_times;
    double all_times;
    int f_times;
    int m_times;
    String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getAll_times() {
        return all_times;
    }

    public void setAll_times(double all_times) {
        this.all_times = all_times;
    }

    public int getF_times() {
        return f_times;
    }

    public void setF_times(int f_times) {
        this.f_times = f_times;
    }

    public int getM_times() {
        return m_times;
    }

    public void setM_times(int m_times) {
        this.m_times = m_times;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getUndergraduate_times() {
        return undergraduate_times;
    }

    public void setUndergraduate_times(int undergraduate_times) {
        this.undergraduate_times = undergraduate_times;
    }

    public int getGraduate_times() {
        return graduate_times;
    }

    public void setGraduate_times(int graduate_times) {
        this.graduate_times = graduate_times;
    }

    public int getTeacher_times() {
        return teacher_times;
    }

    public void setTeacher_times(int teacher_times) {
        this.teacher_times = teacher_times;
    }

    public int getOther_times() {
        return other_times;
    }

    public void setOther_times(int other_times) {
        this.other_times = other_times;
    }

    public int getGctrl_times() {
        return gctrl_times;
    }

    public void setGctrl_times(int gctrl_times) {
        this.gctrl_times = gctrl_times;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
