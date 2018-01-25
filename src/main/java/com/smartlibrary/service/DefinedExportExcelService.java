package com.smartlibrary.service;

import com.smartlibrary.common.ExportExcelUtil;
import com.smartlibrary.dao.definedSearchDao;
import com.smartlibrary.domain.DefinedBookResult;
import com.smartlibrary.domain.DefinedBookSearch;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefinedExportExcelService {
    private static final Logger logger = Logger.getLogger(bookLendService.class);
    @Autowired
    private definedSearchDao definedsearchDao;


    public boolean getDefinedBookSearch(DefinedBookSearch definedBookSearch, Errors errors,HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            exportMap.put("时间", "time");
            exportMap.put("数量", "amount");
            List<DefinedBookResult> definedBookResultList = definedsearchDao.getDefinedBook(definedBookSearch);
            ExportExcelUtil.exportExcel("excel.xlsx",exportMap,definedBookResultList,response,"借阅数据分析");
            return false;
        }
        return true;
    }
}
