package com.smartlibrary.dao;

import com.smartlibrary.domain.DefinedBookResult;
import com.smartlibrary.domain.DefinedBookSearch;

import java.util.List;

public interface definedSearchDao {
    List<DefinedBookResult> getDefinedBook(DefinedBookSearch definedBookSearch);
}
