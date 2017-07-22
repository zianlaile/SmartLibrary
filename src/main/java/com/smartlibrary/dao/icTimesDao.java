package com.smartlibrary.dao;

import com.smartlibrary.domain.IC_Times;

import java.util.List;

/**
 * Created by 胡云飞 on 2017/7/20.
 */
public interface icTimesDao {
    public abstract List<IC_Times> getICTimesByYear();
    public abstract List<IC_Times> getICTimesByMonth();
    public abstract List<IC_Times> getICTimesByDay();
    public abstract List<IC_Times> getICTimesBYTypeAndMonth();
}
