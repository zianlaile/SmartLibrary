package com.smartlibrary.dao;

import com.smartlibrary.domain.Print_Times;

import java.util.List;

/**
 * Created by 胡云飞 on 2017/7/21.
 */
public interface printTimesDao {
    public abstract List<Print_Times> getPrintTimesByyear();
    public abstract List<Print_Times> getPrintAmountByyear();
    public abstract List<Print_Times> getPrintTimesBymonth();
    public abstract List<Print_Times> getPrintTimesByday();
    public abstract List<Print_Times> getPrintTimesBypapertype();
    public abstract List<Print_Times> getPrintTimesBylocation();
    public abstract List<Print_Times> getPrintTimesByprinttype();
    public abstract List<Print_Times> getPrintTimesByprinttypeday();
    public abstract List<Print_Times> getPrintTimesByprinttypemonth();
}
