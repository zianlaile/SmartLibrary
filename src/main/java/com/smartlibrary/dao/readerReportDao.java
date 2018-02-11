package com.smartlibrary.dao;

import com.smartlibrary.domain.*;

import java.util.List;

/**
 * Created by tt on 2017/11/13.
 */
public interface readerReportDao {
    //   <!-- 1. 读者姓名、学院、身份-->
    List<reader_report> getReaderInfo(reader_report n);
    // <!-- 读者第一次进馆时间、累计进馆次数、到馆次数超过校友百分比（例如：超过87%的校友）-->
    List<reader_report> getReaderGctrlInfo(reader_report n);
    //<!-- 读者借阅时间最长的书名及借阅天数、借书总量、借书量排名（如: 排名第87位）-->
    List<reader_report> getReaderBookLendInfo(reader_report n);
    //<!-- 借书最多的书籍类别及借阅该类别书籍的总量（如：文学类，共借阅212本），借阅图书最多的月份及该月借阅数量，借阅各类别图书所占百分比（如：经济42%，外语7%…）-->
    List<reader_report> getReaderMaxBookLendInfo(reader_report n);
    // <!-- 打印页数最多文件的页数及日期、累计文印总量、文印总量排名百分比、文印各类别数量-->
    List<reader_report> getReaderprintInfo(reader_report n);
    //<!-- 座位使用时间最长时长及日期（如：2015年9月16日使用座位4小时）、座位使用总次数、研修间使用总时长-->
    List<reader_report> getReaderDeviceHourInfo(reader_report n);
    // <!-- 每年座位及研修间使用总时长-->
    List<reader_report> getReaderSeatandcroomInfo(reader_report n);
    // <!-- 电子阅览室使用时间最长时长及日期、电子阅览室使用总次数、使用总时长-->
    List<reader_report> getReaderEreadHourInfo(reader_report n);
    //<!-- 借阅图书使用时间最长书名、时长-->
    List<reader_report> getReaderlonggest_book_name_and_days(reader_report n);

    //  <!-- app需要 全校进馆 借阅排名-->
    //List<reader_report> getapp_bookandgctrl_rank(reader_report n);
    //<!-- app需要 进馆排名-->
    Integer getapp_book_rank(reader_report n);
    // <!-- app需要 借阅排名-->
    Integer getapp_gctrl_rank(reader_report n);
    //<!-- app需要 学院进馆排名-->
    Integer getapp_gctrl_academy_rank(reader_report n);
    // <!-- app需要 学院借阅排名-->
    Integer getapp_book_academy_rank(reader_report n);


}
