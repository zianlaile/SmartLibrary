package com.smartlibrary.service;

import com.smartlibrary.dao.definedSearchContentDao;
import com.smartlibrary.dao2.definedSearchContent2Dao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefinedSearchContentService {
    private static final Logger logger = Logger.getLogger(DefinedSearchContentService.class);

    @Autowired
    private definedSearchContentDao definedsearchContentDao;
    @Autowired
    private definedSearchContent2Dao definedsearchContent2Dao;

    public Map<String,List> getDefinedBookSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("academy",definedsearchContentDao.getDefinedAcademyContent());
        data.put("student_style",definedsearchContentDao.getDefinedStudentStyleContent());
        data.put("publisher",definedsearchContentDao.getDefinedPublisherContent());
        data.put("book_style",definedsearchContentDao.getDefinedBookStyleContent());
        return data;
    }

    public Map<String,List> getDefinedGctrlSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("academy",definedsearchContentDao.getDefinedAcademyContent());
        data.put("student_style",definedsearchContentDao.getDefinedStudentStyleContent());
        return data;
    }

    public Map<String,List> getDefinedIcSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("student_style",definedsearchContentDao.getDefinedStudentStyleContent());
        return data;
    }

    public Map<String,List> getDefinedPrintSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("print_location",definedsearchContentDao.getDefinedPrintLocationContent());
        data.put("print_paperType",definedsearchContentDao.getDefinedPrintPaperTypeContent());
        data.put("print_type",definedsearchContentDao.getDefinedPrintTypeContent());
        return data;
    }

    public Map<String,List> getDefinedPersonAssetSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("profession",definedsearchContent2Dao.getDefinedProfessionContent());

        return data;
    }

    public Map<String,List> getDefinedRankContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("academy",definedsearchContentDao.getDefinedAcademyContent());
        data.put("student_style",definedsearchContentDao.getDefinedStudentStyleContent());
        data.put("print_location",definedsearchContentDao.getDefinedPrintLocationContent());
        data.put("print_paperType",definedsearchContentDao.getDefinedPrintPaperTypeContent());
        data.put("print_type",definedsearchContentDao.getDefinedPrintTypeContent());
        return data;
    }



}
