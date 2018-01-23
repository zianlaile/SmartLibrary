package com.smartlibrary.service;

import com.smartlibrary.dao.definedSearchContentDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefinedSearchContentService {
    private static final Logger logger = Logger.getLogger(bookLendService.class);

    @Autowired
    private definedSearchContentDao definedsearchContentDao;

    public Map<String,List> getDefinedSearchContent() {
        Map<String ,List> data=new HashMap<String ,List>();
        data.put("academy",definedsearchContentDao.getDefinedAcademyContent());
        data.put("student_style",definedsearchContentDao.getDefinedStudentStyleContent());
        data.put("publisher",definedsearchContentDao.getDefinedPublisherContent());
        data.put("book_style",definedsearchContentDao.getDefinedBookStyleContent());
        return data;
    }

}
