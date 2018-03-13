package com.smartlibrary.dao;

import com.smartlibrary.domain.DefinedSearchContent;

import java.util.List;

public interface definedSearchContentDao {
    List<DefinedSearchContent> getDefinedAcademyContent();
    List<DefinedSearchContent> getDefinedStudentStyleContent();
    List<DefinedSearchContent> getDefinedStudentSexContent();
    List<DefinedSearchContent> getDefinedPublisherContent();
    List<DefinedSearchContent> getDefinedBookStyleContent();

    List<DefinedSearchContent> getDefinedProfessionContent();
    List<DefinedSearchContent> getDefinedAssetTypeContent();

    List<DefinedSearchContent> getDefinedPrintLocationContent();
    List<DefinedSearchContent> getDefinedPrintPaperTypeContent();
    List<DefinedSearchContent> getDefinedPrintTypeContent();
}
