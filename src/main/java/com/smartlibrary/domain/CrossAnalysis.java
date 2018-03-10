package com.smartlibrary.domain;

/**
 *   * Created by 小章 on 2018/03/09.
 */
public class CrossAnalysis {
    int bookLend;               // 借阅
    int enterLibrary;           // 进馆
    int trainingRoom;           // 研修间
    int digitalReadingRoom;     // 电子阅览室
    int seat;                   // 座位
    int type;
    String  academy;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    int perPerson;

    public int getBookLend() {
        return bookLend;
    }

    public void setBookLend(int bookLend) {
        this.bookLend = bookLend;
    }

    public int getEnterLibrary() {
        return enterLibrary;
    }

    public void setEnterLibrary(int enterLibrary) {
        this.enterLibrary = enterLibrary;
    }

    public int getTrainingRoom() {
        return trainingRoom;
    }

    public void setTrainingRoom(int trainingRoom) {
        this.trainingRoom = trainingRoom;
    }

    public int getDigitalReadingRoom() {
        return digitalReadingRoom;
    }

    public void setDigitalReadingRoom(int digitalReadingRoom) {
        this.digitalReadingRoom = digitalReadingRoom;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getAcademy() {
        return academy;
    }
    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getPerPerson() {
        return perPerson;
    }

    public void setPerPerson(int perPerson) {
        this.perPerson = perPerson;
    }
}
