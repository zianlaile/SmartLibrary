package com.smartlibrary.dao;

import com.smartlibrary.domain.Book_Lend;

import java.util.List;

/**
 * Created by tt on 2017/7/17.
 */
public interface bookLendDao {
    public abstract List<Book_Lend> getBorrowCountByMonth(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByYear(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByDay(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByHourAndAcademy(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByHourAndBookkinds(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountBySexAndBookkinds(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByPublisher(Book_Lend b);
}
