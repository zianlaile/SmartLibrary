package com.smartlibrary.dao;

import java.util.List;

public interface definedContentConvertDao {
    List<String> getDefinedNameOfBookCategoryById(String[] idArray);
    List<String> getDefinedNameOfStudentStyleById(String[] idArray);
    List<String> getDefinedNameOfPaperTypeById(String[] idArray);
}
