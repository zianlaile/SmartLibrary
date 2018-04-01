package com.smartlibrary.common;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExportExcelUtil {
    private static final Logger logger = Logger.getLogger(ExportExcelUtil.class);
    private final static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    /**
     * 导出excel
     *
     * @param fileName
     * @param exportMap
     * @param listContent
     * @param response
     * @return
     */
    @SuppressWarnings("rawtypes")
    public final static String exportExcel(String fileName, Map<String, String> exportMap, List<? extends Object> listContent,
                                           HttpServletResponse response,String title,String subTitle,boolean isAddOrderBefore,String AddOrderBeforeTitle) {
        String result = "success";
        // 以下开始输出到EXCEL
        try {
            // 定义输出流，以便打开保存对话框______________________begin
            // HttpServletResponse response=ServletActionContext.getResponse();
            OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String(fileName.getBytes("GB2312"), "ISO8859-1"));
            // 设定输出文件头
            response.setContentType("application/vnd.ms-excel");// 定义输出类型
            // 定义输出流，以便打开保存对话框_______________________end

            /** **********创建工作簿************ */
            WritableWorkbook workbook = Workbook.createWorkbook(os);

            /** **********创建工作表************ */

            WritableSheet sheet = workbook.createSheet("Sheet1", 0);

            /** **********设置纵横打印（默认为纵打）、打印纸***************** */
            jxl.SheetSettings sheetset = sheet.getSettings();
            sheetset.setProtected(false);

            /** ************设置单元格字体************** */
            WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
            WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

            /** ************以下设置三种单元格样式，灵活备用************ */
            // 用于标题居中
            WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
            wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
            wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
            wcf_center.setWrap(false); // 文字是否换行

            // 用于列名居中
            WritableCellFormat wcf_center2 = new WritableCellFormat(BoldFont);
            /*wcf_center2.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条*/
            wcf_center2.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            wcf_center2.setAlignment(Alignment.CENTRE); // 文字水平对齐
            wcf_center2.setWrap(false); // 文字是否换行

            // 用于正文居中
            WritableCellFormat wcf_center3 = new WritableCellFormat(NormalFont);
            wcf_center3.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
            wcf_center3.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            wcf_center3.setAlignment(Alignment.CENTRE); // 文字水平对齐
            wcf_center3.setWrap(false); // 文字是否换行

            /** ***************以下是EXCEL开头大标题，暂时省略********************* */
            sheet.setRowView(0, sheet.getSettings().getDefaultRowHeight()*2);// 设置第一行宽度
            sheet.mergeCells(0, 0, 6, 0);
            sheet.addCell(new Label(0, 0, title+"（数据量："+listContent.size()+"条)", wcf_center));
            /** ***************以下是EXCEL副标题，暂时省略********************* */
            sheet.setRowView(1, sheet.getSettings().getDefaultRowHeight()*2);// 设置第二行宽度
            sheet.mergeCells(0, 1, 6, 1);
            sheet.addCell(new Label(0, 1, subTitle, wcf_center));
            /** ***************以下是EXCEL第一行列标题********************* */
            Object[] columArr = exportMap.keySet().toArray();
            Object[] filedNameArr = exportMap.values().toArray();
            int temp = 0;
            if(isAddOrderBefore)
                sheet.addCell(new Label(temp++, 2, AddOrderBeforeTitle, wcf_center));
            for (int i=0; i < columArr.length; i++) {
                sheet.addCell(new Label(i+temp, 2, columArr[i].toString(), wcf_center2));
            }
            /** ***************以下是EXCEL正文数据********************* */
            int i = 3;
            for (Object obj : listContent) {

                int j = 0;
                String fieldNameTemp = null;
                Object value = null;
                Method method=null;
                Class methodTypeClass=null;
                if(isAddOrderBefore){
                    sheet.addCell(new Label(j, i, String.valueOf(i-2), wcf_center3));
                    j++;
                }
                for (Object fieldName : filedNameArr) {
                    fieldNameTemp = "get" + fieldName.toString().substring(0, 1).toUpperCase()
                            + fieldName.toString().substring(1);
                    method = obj.getClass().getMethod(fieldNameTemp, null);
                    methodTypeClass = method.getReturnType();
                    //时间格式转换
                    if (Date.class.getSimpleName().equals(methodTypeClass.getSimpleName())) {
                        value = dateFormat.format((Date)method.invoke(obj, null));
                    }else if(int.class.getSimpleName().equals(methodTypeClass.getSimpleName())){
                        jxl.write.Number labelNF = new jxl.write.Number(j, j,
                                i, wcf_center3); // 格式化数值
                        sheet.addCell(new jxl.write.Number(j, i,(int)method.invoke(obj, null) , wcf_center3));
                        j++;
                        continue;
                    }else{
                        value = method.invoke(obj, null);
                    }
                    if (value == null) {
                        value = "";
                    }
                    sheet.addCell(new Label(j, i, value.toString(), wcf_center3));
                    j++;
                }
                i++;
            }
            /** **********将以上缓存中的内容写到EXCEL文件中******** */
            workbook.write();
            /** *********关闭文件************* */
            workbook.close();
            logger.info("导出excel成功");

        } catch (Exception e) {
            result = "error";
            logger.error("导出excel失败", e);
        }
        return result;
    }

    /**
     * 导出excel
     *
     * @param fileName
     * @param exportMap
     * @param listContent
     * @param response
     * @return
     */
    @SuppressWarnings("rawtypes")
    public final static String exportExcel(String fileName, Map<String, String> exportMap, List<? extends Object> listContent,
                                           HttpServletResponse response,String title,String subTitle) {
        return exportExcel(fileName,exportMap,listContent,response,title,subTitle,false,"");
    }
}
