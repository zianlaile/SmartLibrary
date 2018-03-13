package com.smartlibrary.service;

import com.smartlibrary.common.ExportExcelUtil;
import com.smartlibrary.dao.definedSearchContentDao;
import com.smartlibrary.dao.definedSearchDao;
import com.smartlibrary.dao2.definedSearch2Dao;
import com.smartlibrary.domain.*;
import com.smartlibrary.domain2.DefinedPersonAssetSearch;
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
    private static final Logger logger = Logger.getLogger(DefinedExportExcelService.class);
    @Autowired
    private definedSearchDao definedsearchDao;
    @Autowired
    private definedSearchContentDao definedsearchContentDao;

    public boolean getDefinedBookSearch(DefinedBookSearch definedBookSearch, Errors errors,HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            exportMap.put("时间", "time");
            if(definedBookSearch.getLend_style()==0)
                exportMap.put("借书数量", "amount");
            else if(definedBookSearch.getLend_style()==1)
                exportMap.put("还书数量", "amount");
            else
                exportMap.put("续借数量", "amount");
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedBook(definedBookSearch);
            ExportExcelUtil.exportExcel("借阅数据分析.xls",exportMap, definedResultList,response,"借阅数据分析",definedBookSearch.getSearchContentSubTitle(definedsearchContentDao.getDefinedBookStyleContent()));
            return false;
        }
        return true;
    }
    public boolean getDefinedGctrlSearch(DefinedGctrlSearch definedGctrlSearch, Errors errors, HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            if(definedGctrlSearch.getStyle()==0){
                exportMap.put("时间", "time");
            }else{
                exportMap.put("学院", "academy");
            }
            exportMap.put("进馆次数", "amount");
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedGctrl(definedGctrlSearch);
            ExportExcelUtil.exportExcel("进馆数据分析.xls",exportMap, definedResultList,response,"进馆数据分析",definedGctrlSearch.getSearchContentSubTitle());
            return false;
        }
        return true;
    }
    public boolean getDefinedIcSearch(DefinedIcSearch definedIcSearch, Errors errors, HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            exportMap.put("时间", "time");
            if(definedIcSearch.getStyle()==0){
                exportMap.put("时长(分)", "amount");
            }else{
                exportMap.put("人次", "amount");
            }
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedIc(definedIcSearch);
            ExportExcelUtil.exportExcel("IC空间数据分析.xls",exportMap, definedResultList,response,"IC空间数据分析",definedIcSearch.getSearchContentSubTitle(definedsearchContentDao.getDefinedStudentStyleContent()));
            return false;
        }
        return true;
    }
    public boolean getDefinedPrintSearch(DefinedPrintSearch definedPrintSearch, Errors errors, HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            exportMap.put("时间", "time");
            exportMap.put("数量(张)", "amount");
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedPrint(definedPrintSearch);
            ExportExcelUtil.exportExcel("自助打印复印分析.xls",exportMap, definedResultList,response,"自助打印复印分析",definedPrintSearch.getSearchContentSubTitle(definedsearchContentDao.getDefinedPrintPaperTypeContent()));
            return false;
        }
        return true;
    }
    public boolean getDefinedPersonAssetSearch(DefinedPersonAssetSearch definedPersonAssetSearch, Errors errors, HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            exportMap.put("时间", "year");
            if(definedPersonAssetSearch.getStyle()==0){
                exportMap.put("人次", "amount");
            }else{
                exportMap.put("总数", "amount");
            }
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedPersonAsset(definedPersonAssetSearch);
            ExportExcelUtil.exportExcel("人员资产统计.xls",exportMap, definedResultList,response,"人员资产统计",definedPersonAssetSearch.getSearchContentSubTitle());
            return false;
        }
        return true;
    }

    public boolean getDefinedRankSearch(DefinedRankSearch definedRankSearch, Errors errors,HttpServletResponse response) {
        if(!errors.hasErrors()){
            Map<String,String> exportMap=new HashMap<String,String>();
            String first_title,second_title,title;
            if(definedRankSearch.getRank_style()==0){
                if(definedRankSearch.getBook_rank_type()==0)
                    first_title="图书";
                else
                    first_title="学生";
                second_title="借阅量";
                title=first_title+"借阅量排行";
            }else if(definedRankSearch.getRank_style()==1){
                first_title="时间";
                second_title="进馆次数";
                title="进馆次数排行";
            }else{
                first_title="时间";
                second_title="打印复印次数";
                title="打印复印次数排行";
            }
            exportMap.put(first_title, "x_data");
            exportMap.put(second_title, "amount");
            List<DefinedResult> definedResultList = definedsearchDao.getDefinedRank(definedRankSearch);
            ExportExcelUtil.exportExcel("统计排行分析.xls",exportMap, definedResultList,response,title,definedRankSearch.getSearchContentSubTitle(definedsearchContentDao.getDefinedPrintPaperTypeContent()),true,"排名");
            return false;
        }
        return true;
    }
}
