package com.smartlibrary.domain;

/**
 * Created by tt on 2017/10/10.
 */
public class app_baseinfo {
    int id;
    int dwDevID;
    String szDevName;
    int dwUnitPrice;
    String dwPurchaseDate;
    String szRoomNo;
    String szFloorNo;
    String szKeeperName;
    String szKeeperTel;
    String szProducerName;
    String szServiceTel;
    String  szMemo;
    int pageSize;//一页多少数据
    int offset; //从第几条数据开始查

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDwDevID() {
        return dwDevID;
    }

    public void setDwDevID(int dwDevID) {
        this.dwDevID = dwDevID;
    }

    public String getSzDevName() {
        return szDevName;
    }

    public void setSzDevName(String szDevName) {
        this.szDevName = szDevName;
    }

    public int getDwUnitPrice() {
        return dwUnitPrice;
    }

    public void setDwUnitPrice(int dwUnitPrice) {
        this.dwUnitPrice = dwUnitPrice;
    }

    public String getDwPurchaseDate() {
        return dwPurchaseDate;
    }

    public void setDwPurchaseDate(String dwPurchaseDate) {
        this.dwPurchaseDate = dwPurchaseDate;
    }

    public String getSzRoomNo() {
        return szRoomNo;
    }

    public void setSzRoomNo(String szRoomNo) {
        this.szRoomNo = szRoomNo;
    }

    public String getSzFloorNo() {
        return szFloorNo;
    }

    public void setSzFloorNo(String szFloorNo) {
        this.szFloorNo = szFloorNo;
    }

    public String getSzKeeperName() {
        return szKeeperName;
    }

    public void setSzKeeperName(String szKeeperName) {
        this.szKeeperName = szKeeperName;
    }

    public String getSzKeeperTel() {
        return szKeeperTel;
    }

    public void setSzKeeperTel(String szKeeperTel) {
        this.szKeeperTel = szKeeperTel;
    }

    public String getSzProducerName() {
        return szProducerName;
    }

    public void setSzProducerName(String szProducerName) {
        this.szProducerName = szProducerName;
    }

    public String getSzServiceTel() {
        return szServiceTel;
    }

    public void setSzServiceTel(String szServiceTel) {
        this.szServiceTel = szServiceTel;
    }

    public String getSzMemo() {
        return szMemo;
    }

    public void setSzMemo(String szMemo) {
        this.szMemo = szMemo;
    }
}
