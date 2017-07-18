package com.smartlibrary.dao;

import com.smartlibrary.domain.Book_Lend;

import java.util.List;

/**
 * Created by tt on 2017/7/17.
 */
public interface bookLendDao {
    public abstract List<Book_Lend> getBorrowCountByMonth(Book_Lend b);
    public abstract List<Book_Lend> getBorrowCountByYear(Book_Lend b);
}
