package com.smartlibrary.domain;

/**
 * Created by 胡云飞 on 2017/7/20.
 */
public class IC_Times extends BaseObject{
    private int year;
    private int month;
    private int day;
    private int seat_times;
    private int eread_times;
    private int croom_times;
    private int equipment_times;
    private String time;
    private String user_type;
    private int seat_duration;
    private int croom_duration;

    public int getSeat_duration() {
        return seat_duration;
    }

    public void setSeat_duration(int seat_duration) {
        this.seat_duration = seat_duration;
    }

    public int getCroom_duration() {
        return croom_duration;
    }

    public void setCroom_duration(int croom_duration) {
        this.croom_duration = croom_duration;
    }

    public int getEread_duration() {
        return eread_duration;
    }

    public void setEread_duration(int eread_duration) {
        this.eread_duration = eread_duration;
    }

    public int getEquipment_duration() {
        return equipment_duration;
    }

    public void setEquipment_duration(int equipment_duration) {
        this.equipment_duration = equipment_duration;
    }

    private int eread_duration;
    private int equipment_duration;

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public int getEquipment_times() {
        return equipment_times;
    }

    public void setEquipment_times(int equipment_times) {
        this.equipment_times = equipment_times;
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

    public int getSeat_times() {
        return seat_times;
    }

    public void setSeat_times(int seat_times) {
        this.seat_times = seat_times;
    }

    public int getEread_times() {
        return eread_times;
    }

    public void setEread_times(int eread_times) {
        this.eread_times = eread_times;
    }

    public int getCroom_times() {
        return croom_times;
    }

    public void setCroom_times(int croom_times) {
        this.croom_times = croom_times;
    }
}
