package com.smartlibrary.service;

import com.smartlibrary.dao.schoolReportDao;
import com.smartlibrary.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * Created by tt on 2017/10/17.
 */
@Service
public class schoolReportService {
    @Autowired
    private schoolReportDao schoolReportdao;

    //年度藏书文献总量
    public List<app_resources> getResourceCountBy_year(app_resources n){
        return schoolReportdao.getResourceCountBy_year(n);
    };
    //年度入馆总人次
    public  List<real_year_counts> getGctrlsCountBy_year(real_year_counts n){
        return schoolReportdao.getGctrlsCountBy_year(n);
    };
    //按月入馆人次
    public  List<gctrl> getGctrlsCountBy_month(gctrl n){
        return schoolReportdao.getGctrlsCountBy_month(n);
    };
    //年度借还总次数，借阅次数，还书次数
    public List<Book_Lend> getBook_LendCountBy_year(Book_Lend n){
        return schoolReportdao.getBook_LendCountBy_year(n);
    };
    //年度各学院借阅人次，还书人次
    public List<library_report_academy> getBook_LendCountBy_academyAndyear(library_report_academy n){
        return schoolReportdao.getBook_LendCountBy_academyAndyear(n);
    };
    //年度借阅人次前三学院名称
    public  List<library_report_academy> getLendTop3By_academyAndyear(library_report_academy n){
        return schoolReportdao.getLendTop3By_academyAndyear(n);
    };
    //年度人均借阅前3学院名称
    public  List<library_report_academy> getpreLendTop3By_academyAndyear(library_report_academy n){
        return schoolReportdao.getpreLendTop3By_academyAndyear(n);
    };
    //年度各学院借书比
    public  List<library_report_academy> getLendratioBy_academyAndyear(library_report_academy n){
        return schoolReportdao.getLendratioBy_academyAndyear(n);
    };
    //年度总借阅次数前十学生
    //年度总借阅次数前二十图书
    public  List<library_report_ranking_book> getop20bookBy_year(library_report_ranking_book n){
        return schoolReportdao.getop20bookBy_year(n);
    };
    //年度总借阅次数前二十著者
    public  List<library_report_ranking_author> getop20authorBy_year(library_report_ranking_author n){
        return schoolReportdao.getop20authorBy_year(n);
    };
    //年度在座时长统计
    public List<library_report_IC_duration> geICdurationBy_year(library_report_IC_duration n){
        return schoolReportdao.geICdurationBy_year(n);
    };
    //年度电子阅览室使用次数统计
    public  List<IC_Times> geICdurationCountBy_year(IC_Times n){
        return schoolReportdao.geICdurationCountBy_year(n);
    };






    //<!--今年读者总借阅次数排名前10（包括学号、读者姓名、所属学院、总借阅次数）（表格）新表-学号-年份-->
    public List<reader_report> getReder_booklendCount_Byyear(reader_report n){
        return schoolReportdao.getReder_booklendCount_Byyear(n);
    };
    //<!--年度设备平均使用次数统计-->
    public  List<library_report_hour> getDeviceCount_Byhour(library_report_hour n){
        return schoolReportdao.getDeviceCount_Byhour(n);
    };
    //<!-- 年度各时段图书平均借出册数及人数（如8:00-9:00借出39册，21人借阅）（折线）-->
    public  List<library_report_hour> getbooklendPeopleAndCount_Byhour(library_report_hour n){
        return schoolReportdao.getbooklendPeopleAndCount_Byhour(n);
    };
    // <!--年度全校读者借阅分类统计-->
    public  List<Book_Lend> getBookkindAllCount_Byyear(Book_Lend n){
        return schoolReportdao.getBookkindAllCount_Byyear(n);
    };
    // <!--3. 有借阅记录的教职工读者人数-->
    public  List<Book_Lend> getTeacherLendCount(Book_Lend n){
        return schoolReportdao.getTeacherLendCount(n);
    };
    // < <!--教职工读者共借阅图书册数-->
    public List<Book_Lend> getTeacherLendCount_Byyear(Book_Lend n){
        return schoolReportdao.getTeacherLendCount_Byyear(n);
    };

    //<!--2011年-2017年教职工借阅人数统计（包括：<10册, 11-20册, 21-30册, 31-50册, 51-100册, 101-200册, 201-300册, >300册）（表格）
    // 做起来麻烦点 ，循环一下，lend，back 借用一下做大小值-->
    public Map<String, Object> getTeacherCount_BycountAndyear(library_report_month_mankinds n){
        Map<String, Object> map = new HashMap<String, Object>();
        String str="";
        for(int i=1;i<9;i++)
        {
            switch(i){
                case 1: n.setLend(0);n.setBack(11); str="<10册";break;
                case 2:n.setLend(10);n.setBack(21); str="11-20册";break;
                case 3:n.setLend(20);n.setBack(31); str="21-30册";break;
                case 4:n.setLend(30);n.setBack(51); str="31-50册";break;
                case 5:n.setLend(50);n.setBack(101); str="51-100册";break;
                case 6:n.setLend(100);n.setBack(201);str="101-200册"; break;
                case 7:n.setLend(200);n.setBack(301); str="201-300册";break;
                case 8:n.setLend(300);n.setBack(9999991);str=">300册"; break;
            }
            map.put(str,schoolReportdao.getTeacherCount_BycountAndyear(n));
        }
        return map;
    };
    // <!--  ?历年各大类图书借书比例趋势图（2011-2017年，包括：I文学、O数理化、F经济、TP计算机、K历史地理、B哲学宗教、D政治法律、H语言文字、其他）（折线图）（top5的类别数据）-->
    public   List<Book_Lend> getTop5bookkind_Byyear(Book_Lend n){
        return schoolReportdao.getTop5bookkind_Byyear(n);
    };
    /*<!--  6. 年度图书馆进馆读者类型比例（包括本科生、硕士生、教职工、其他）（饼图）
    7. 2011-2017年进馆读者类型比例趋势（包括本科生、硕士生、教职工、其他）
    8. 年度各类型读者借书比例（包括本科生、硕士生、教职工、其他）（柱状图）
    9. 年度各类型读者续借比例（包括本科生、硕士生、教职工、其他）（柱状图）-->*/
    public   List<library_report_month_mankinds> getmankindCount_Byyear(library_report_month_mankinds n){
        return schoolReportdao.getmankindCount_Byyear(n);
    };

    public   List<library_report_month_mankinds> getmankindCount_Byoneyear(library_report_month_mankinds n){
        return schoolReportdao.getmankindCount_Byoneyear(n);
    }
    public Map<String,List> gettypeprints(){
        Map<String,List> returntype = new HashMap<>();
        List<Print_Times> gettypeList = schoolReportdao.gettypeprints();
        List<Integer> year = new ArrayList<>();
        List<Integer> print = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();
        List<Integer> scan = new ArrayList<>();
        for(int i=0;i<gettypeList.size();i++){
            if(!year.contains(gettypeList.get(i).getYear())){
                year.add(gettypeList.get(i).getYear());
            }
            if(gettypeList.get(i).getPrint_type().equals("C")){
                copy.add(gettypeList.get(i).getPrint_times());
            }
            else if(gettypeList.get(i).getPrint_type().equals("S")){
                scan.add(gettypeList.get(i).getPrint_times());
            }
            else if(gettypeList.get(i).getPrint_type().equals("P")){
                print.add(gettypeList.get(i).getPrint_times());
            }
        }
        returntype.put("year",year);
        returntype.put("print",print);
        returntype.put("scan",scan);
        returntype.put("copy",copy);
        return returntype;
    }

    public Map<String,List> gettypeprintsamount(){
        Map<String,List> returntype = new HashMap<>();
        List<Print_Times> gettypeList = schoolReportdao.gettypeprintsamount();
        List<Integer> year = new ArrayList<>();
        List<Integer> print = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();
        List<Integer> scan = new ArrayList<>();
        for(int i=0;i<gettypeList.size();i++){
            if(!year.contains(gettypeList.get(i).getYear())){
                year.add(gettypeList.get(i).getYear());
            }
            if(gettypeList.get(i).getPrint_type().equals("C")){
                copy.add(gettypeList.get(i).getPrint_times());
            }
            else if(gettypeList.get(i).getPrint_type().equals("S")){
                scan.add(gettypeList.get(i).getPrint_times());
            }
            else if(gettypeList.get(i).getPrint_type().equals("P")){
                print.add(gettypeList.get(i).getPrint_times());
            }
        }
        returntype.put("year",year);
        returntype.put("print",print);
        returntype.put("scan",scan);
        returntype.put("copy",copy);
        return returntype;
    }






    // <!--研修间-使用量分析（一年，四个类别） 时间要改，暂时2015-->
    public Map<String,List> getICTimesBYTypeOneyear( IC_Times ii){
        Map typeandmonthdata = new HashMap<String,List>();
        List<IC_Times> gettypeandmonthdata= schoolReportdao.getICTimesBYTypeOneyear(ii);
        List croomtimesg = new ArrayList<Integer>();
        List croomtimeso = new ArrayList<Integer>();
        List croomtimest = new ArrayList<Integer>();
        List croomtimesu = new ArrayList<Integer>();

        List ereadtimesg = new ArrayList<Integer>();
        List ereadtimeso = new ArrayList<Integer>();
        List ereadtimest = new ArrayList<Integer>();
        List ereadtimesu = new ArrayList<Integer>();

        List seattimesg = new ArrayList<Integer>();
        List seattimeso = new ArrayList<Integer>();
        List seattimest = new ArrayList<Integer>();
        List seattimesu = new ArrayList<Integer>();

        List equipmenttimesg = new ArrayList<Integer>();
        List equipmenttimeso = new ArrayList<Integer>();
        List equipmenttimest = new ArrayList<Integer>();
        List equipmenttimesu = new ArrayList<Integer>();

        List month = new ArrayList<String>();
        for(int i=0;i<gettypeandmonthdata.size();i++){
            if(!month.contains(String.valueOf(gettypeandmonthdata.get(i).getYear())+"/"+String.valueOf(gettypeandmonthdata.get(i).getMonth()))){
                month.add(String.valueOf(gettypeandmonthdata.get(i).getYear())+"/"+String.valueOf(gettypeandmonthdata.get(i).getMonth()));
            }
            if(gettypeandmonthdata.get(i).getUser_type().equals("G")){
                croomtimesg.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimesg.add(gettypeandmonthdata.get(i).getEread_times());
                seattimesg.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimesg.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("O")){
                croomtimeso.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimeso.add(gettypeandmonthdata.get(i).getEread_times());
                seattimeso.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimeso.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("T")){
                croomtimest.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimest.add(gettypeandmonthdata.get(i).getEread_times());
                seattimest.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimest.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
            else if(gettypeandmonthdata.get(i).getUser_type().equals("U")){
                croomtimesu.add(gettypeandmonthdata.get(i).getCroom_times());
                ereadtimesu.add(gettypeandmonthdata.get(i).getEread_times());
                seattimesu.add(gettypeandmonthdata.get(i).getSeat_times());
                equipmenttimesu.add(gettypeandmonthdata.get(i).getEquipment_times());
            }
        }

        typeandmonthdata.put("croomtimesg",croomtimesg);
        typeandmonthdata.put("croomtimeso",croomtimeso);
        typeandmonthdata.put("croomtimest",croomtimest);
        typeandmonthdata.put("croomtimesu",croomtimesu);
        typeandmonthdata.put("ereadtimesg",ereadtimesg);
        typeandmonthdata.put("ereadtimeso",ereadtimeso);
        typeandmonthdata.put("ereadtimest",ereadtimest);
        typeandmonthdata.put("ereadtimesu",ereadtimesu);
        typeandmonthdata.put("seattimesg",seattimesg);
        typeandmonthdata.put("seattimeso",seattimeso);
        typeandmonthdata.put("seattimest",seattimest);
        typeandmonthdata.put("seattimesu",seattimesu);
        typeandmonthdata.put("equipmenttimesg",equipmenttimesg);
        typeandmonthdata.put("equipmenttimeso",equipmenttimeso);
        typeandmonthdata.put("equipmenttimest",equipmenttimest);
        typeandmonthdata.put("equipmenttimesu",equipmenttimesu);
        typeandmonthdata.put("month",month);
        return typeandmonthdata;
    }

    //   <!--馆藏基本情况  总体情况 馆数量太多 取前十-->
    public Map<String,List> getCollectionOverall(CollectionBook b) {
        List<CollectionBook> data= schoolReportdao.getCollectionOverall(b);
        ArrayList<String> stack=new  ArrayList<String>();
        ArrayList<Integer> amount=new  ArrayList<Integer>();
        Map<String ,List> result=new HashMap<String ,List>();
        for(int i=0;i<data.size();i++){
            stack.add(data.get(i).getStack());
            amount.add(data.get(i).getAmount());
        }
        result.put("stack",stack);
        result.put("amount",amount);
        result.put("object",data);
        return result;
    }
    //   <!--馆藏基本情况  当年新增情况 馆数量太多 取前十-->
    public Map<String,List> getCollectionNewAdded(CollectionBook b) {
        List<CollectionBook> data= schoolReportdao.getCollectionNewAdded(b);
        ArrayList<String> stack=new  ArrayList<String>();
        ArrayList<Integer> amount=new  ArrayList<Integer>();
        Map<String ,List> result=new HashMap<String ,List>();
        for(int i=0;i<data.size();i++){
            stack.add(data.get(i).getStack());
            amount.add(data.get(i).getAmount());
        }
        result.put("stack",stack);
        result.put("amount",amount);
        result.put("object",data);
        return result;
    }

    //   <!--馆藏基本情况  新增馆藏分类分布 类别太多 取前十-->
    public Map<String,List> getCollectionNewAddedByCate(CollectionBook b) {
        List<CollectionBook> data= schoolReportdao.getCollectionNewAddedByCate(b);
        ArrayList<String> category=new  ArrayList<String>();
        ArrayList<String> booktype=new ArrayList<String>();
        TreeMap <String,ArrayList<Integer>> value=new TreeMap <String,ArrayList<Integer>>();

        Map<String ,List> result=new HashMap<String ,List>();
        for(int i=0;i<data.size();i++){
            String  cate=data.get(i).getCategory() +"("+data.get(i).getCategoryname()+")";
            String  bk=data.get(i).getBookType();
            if(!booktype.contains(bk)) {
                booktype.add(bk);
            }
            int  am=data.get(i).getAmount();
            if(!value.containsKey(bk)) {
                value.put(bk,new ArrayList<Integer>());
                value.get(bk).add(am);
            }else{
                value.get(bk).add(am);
            }
            if(!category.contains(cate) ){
                category.add(cate);
            }
        }

        ArrayList<Map> values=new ArrayList<Map>();
        values.add(value);
        result.put("category",category);
        result.put("booktype",booktype);
        result.put("values",values);
        return result;
    }

    // <!--馆藏基本情况  新增图书分类分布 类别太多 取前十-->
    public Map<String,List> getCollectionTuShuNewAddedByCate(CollectionBook b) {
        List<CollectionBook> data= schoolReportdao.getCollectionTuShuNewAddedByCate(b);
        ArrayList<String> category=new  ArrayList<String>();
        ArrayList<String> booktype=new ArrayList<String>();
        TreeMap <String,ArrayList<Integer>> value=new TreeMap <String,ArrayList<Integer>>();

        Map<String ,List> result=new HashMap<String ,List>();
        for(int i=0;i<data.size();i++){
            String  cate=data.get(i).getCategory();
            String  bk=data.get(i).getBookType();
            if(!booktype.contains(bk)) {
                booktype.add(bk);
            }
            int  am=data.get(i).getAmount();
            if(!value.containsKey(bk)) {
                value.put(bk,new ArrayList<Integer>());
                value.get(bk).add(am);
            }else{
                value.get(bk).add(am);
            }
            if(!category.contains(cate) ){
                category.add(cate);
            }
        }

        ArrayList<Map> values=new ArrayList<Map>();
        values.add(value);
        result.put("category",category);
        result.put("booktype",booktype);
        result.put("values",values);
        return result;
    }
    // <!--馆藏基本情况  新增外文分类分布 类别太多 取前十-->
    public  Map<String,List> getCollectionWaiWenNewAddedByCate(CollectionBook b) {
        List<CollectionBook> data= schoolReportdao.getCollectionWaiWenNewAddedByCate(b);
        ArrayList<String> category=new  ArrayList<String>();
        ArrayList<String> booktype=new  ArrayList<String>();

        ArrayList<Integer> WWTS=new  ArrayList<Integer>();

        Map<String ,List> result=new HashMap<String ,List>();
        int count=0;
        for(int i=0;i<data.size();i++){
            String  cate=data.get(i).getCategory();
            if(!category.contains(cate) ){
                category.add(cate);
            }
            String  bk=data.get(i).getBookType();
            if(!booktype.contains(bk)) {
                booktype.add(bk);
            }
            int  am=data.get(i).getAmount();
            WWTS.add(am);
            count=count+am;
        }
        List<Integer> counts =new LinkedList<Integer>();
        counts.add(count);
        result.put("category",category);
        result.put("booktype",booktype);
        result.put("外文图书",WWTS);
        result.put("count",counts);
        return result;
    }

    public Map<String, List> getCollectionAmountType(String year){
        Calendar now = Calendar.getInstance();
        List<CollectionBook> collectionList = schoolReportdao.getCollectionAmountType();
        List<CollectionBook> thisyearCollection = schoolReportdao.getCollectionAmountTypeYear(Integer.valueOf(year));
        List<CollectionBook> pubyearCollection = schoolReportdao.getCollectionAmountTypePubyear();
        List<String> stack = new ArrayList<>();
        List<String> stackthisyear = new ArrayList<>();
        List<String> stackpubyear = new ArrayList<>();
        List<Integer> amounttype = new ArrayList<>();
        List<Integer> amounttypeYear = new ArrayList<>();
        List<Integer> amounttypePubyear = new ArrayList<>();
        Map<String,List> CollectionAmountType = new HashMap<>();
        for(int i=0;i<collectionList.size();i++){
            stack.add(collectionList.get(i).getStack());
            amounttype.add(collectionList.get(i).getAmounttype());
        }
        for(int i=0;i<thisyearCollection.size();i++){
            stackthisyear.add(thisyearCollection.get(i).getStack());
            amounttypeYear.add(thisyearCollection.get(i).getAmounttype());
        }
        for(int i=0;i<pubyearCollection.size();i++){
            stackpubyear.add(pubyearCollection.get(i).getStack());
            amounttypePubyear.add(pubyearCollection.get(i).getAmounttype());
        }
        CollectionAmountType.put("stack",stack);
        CollectionAmountType.put("amounttype",amounttype);
        CollectionAmountType.put("stackthisyear",stackthisyear);
        CollectionAmountType.put("amounttypeYear",amounttypeYear);
        CollectionAmountType.put("stackpubyear",stackpubyear);
        CollectionAmountType.put("amounttypePubyear",amounttypePubyear);
        return CollectionAmountType;
    }

    public Map<String,List> getCollectionByStackAndBooktype(){
        List<CollectionBook> CollectionByStackAndBooktype = schoolReportdao.getCollectionByStackAndBooktype();
        Map<String,List> returnmap = new HashMap<>();
        List<String> stack = new ArrayList<>();
        List<String> bookType = new ArrayList<>();
        List<Integer> amounttype = new ArrayList<>();
        List<Integer> amountnumber = new ArrayList<>();
        for(int i=0;i<CollectionByStackAndBooktype.size();i++){
            if(!stack.contains(CollectionByStackAndBooktype.get(i).getStack())){
                stack.add(CollectionByStackAndBooktype.get(i).getStack());
            }
            if(!bookType.contains(CollectionByStackAndBooktype.get(i).getBookType())){
                bookType.add(CollectionByStackAndBooktype.get(i).getBookType());
            }
            amounttype.add(CollectionByStackAndBooktype.get(i).getAmounttype());
            amountnumber.add(CollectionByStackAndBooktype.get(i).getAmountnumber());
        }
        returnmap.put("stack",stack);
        returnmap.put("bookType",bookType);
        returnmap.put("amounttype",amounttype);
        returnmap.put("amountnumber",amountnumber);
        return returnmap;
    }

    public Map<String,CollectionBook> getCollectionByPubyear(){
        CollectionBook pubyearcollection = new CollectionBook();
        Map<String,CollectionBook> returndata = new HashMap<>();
        for(int i=1;i<=12;i++){
            switch (i){
                case 1:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(0,1919);
                    returndata.put("-1919",pubyearcollection);
                    break;
                case 2:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1920,1929);
                    returndata.put("1920-1929",pubyearcollection);
                    break;
                case 3:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1930,1939);
                    returndata.put("1930-1939",pubyearcollection);
                    break;
                case 4:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1940,1949);
                    returndata.put("1940-1949",pubyearcollection);
                    break;
                case 5:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1950,1959);
                    returndata.put("1950-1959",pubyearcollection);
                    break;
                case 6:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1960,1969);
                    returndata.put("1960-1969",pubyearcollection);
                    break;
                case 7:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1970,1979);
                    returndata.put("1970-1979",pubyearcollection);
                    break;
                case 8:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1980,1989);
                    returndata.put("1980-1989",pubyearcollection);
                    break;
                case 9:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(1990,1999);
                    returndata.put("1990-1999",pubyearcollection);
                    break;
                case 10:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(2000,2009);
                    returndata.put("2000-2009",pubyearcollection);
                    break;
                case 11:
                    pubyearcollection = schoolReportdao.getCollectionByPubyear(2010,9999);
                    returndata.put("2010-",pubyearcollection);
                    break;
                case 12:
                    pubyearcollection = schoolReportdao.getCollectionByPubyearUnknow();
                    returndata.put("不详",pubyearcollection);
                    break;
            }
        }
        return returndata;
    }

    public Map<String,List> getCollectionBycategory(){
        List<CollectionBook> CollectionBycategory = schoolReportdao.getCollectionBycategory();
        Map<String,List> CollectionBycategorydata = new HashMap<>();
        List<String> category = new ArrayList<>();
        List<String> bookType = new ArrayList<>();
        List<Integer> amounttype = new ArrayList<>();
        List<Integer> amountnumber = new ArrayList<>();
        for(int i=0;i<CollectionBycategory.size();i++){
            if(!category.contains(CollectionBycategory.get(i).getCategory()+"("+CollectionBycategory.get(i).getCategoryname()+")")){
                category.add(CollectionBycategory.get(i).getCategory()+"("+CollectionBycategory.get(i).getCategoryname()+")");
            }
            if(!bookType.contains(CollectionBycategory.get(i).getBookType())){
                bookType.add(CollectionBycategory.get(i).getBookType());
            }
            amounttype.add(CollectionBycategory.get(i).getAmounttype());
            amountnumber.add(CollectionBycategory.get(i).getAmountnumber());
        }
        CollectionBycategorydata.put("category",category);
        CollectionBycategorydata.put("bookType",bookType);
        CollectionBycategorydata.put("amounttype",amounttype);
        CollectionBycategorydata.put("amountnumber",amountnumber);
        return CollectionBycategorydata;
    }

    public Map<String,List> getTop10category(){
        List<CollectionBook> Top10category = schoolReportdao.getTop10category();
        Map<String,List> Top10categorydata = new HashMap<>();
        List<String> category = new ArrayList<>();
        List<Integer> amounttype = new ArrayList<>();
        for(int i=0;i<Top10category.size();i++){
            if(Top10category.get(i).getCategoryname()!=null){
                category.add(Top10category.get(i).getCategory()+"("+Top10category.get(i).getCategoryname()+")");
            }
            else{
                category.add(Top10category.get(i).getCategory());
            }
            amounttype.add(Top10category.get(i).getAmounttype());
        }
        Top10categorydata.put("category",category);
        Top10categorydata.put("amounttype",amounttype);
        return Top10categorydata;
    }

    /*
    int book_categoryAmount;     //  各类统计
    String reader_academy;       //  读者学院
    String book_category;        //  书本种类
    */
    public  Map<Integer, Map<String,List>>getYearTop3CategoryByAcademy(){
        List<Book_Lend> getYearTop3CategoryByAcademy = schoolReportdao.getYearTop3CategoryByAcademy();  // 得到数据
        Map<Integer, Map<String,List>> yearTop3CategoryByAcademy = new HashMap<>();                     // 返回值
        List<String> bookCategory = new ArrayList<>();                                                  // 种类数据
        List<String> readerAcademy = new ArrayList<>();                                                 // 读者学院
        List<Integer> categoryAmount = new ArrayList<>();                                               // 种类统计
        int  rankFlag = 1;  // 标记读者排名
        for(int i = 1; i < getYearTop3CategoryByAcademy.size(); i ++ ){
            bookCategory.add(getYearTop3CategoryByAcademy.get(i-1).getBook_category());
            if(!readerAcademy.contains(getYearTop3CategoryByAcademy.get(i-1).getReader_academy())){
                readerAcademy.add(getYearTop3CategoryByAcademy.get(i-1).getReader_academy());
            }
            categoryAmount.add(getYearTop3CategoryByAcademy.get(i-1).getCategoryAmount());
            if(!(getYearTop3CategoryByAcademy.get(i).getReader_academy().equals(getYearTop3CategoryByAcademy.get(i-1).getReader_academy()))) {
                Map<String,List> temp =  new HashMap<>();
                temp.put("bookCategory",new ArrayList<String>(bookCategory));
                temp.put("readerAcademy",new ArrayList<String>(readerAcademy));
                temp.put("categoryAmount",new ArrayList<Integer>(categoryAmount));
                yearTop3CategoryByAcademy.put(rankFlag,copyList(temp));
                bookCategory.clear();
                readerAcademy.clear();
                categoryAmount.clear();
                rankFlag++;
            }
        }
        // 处理最后一条数据
        if(!readerAcademy.contains(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getReader_academy())){
            readerAcademy.add(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getReader_academy());
        }

        if(!readerAcademy.contains(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getReader_academy())){
            readerAcademy.add(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getReader_academy());
        }

        bookCategory.add(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getBook_category());
        categoryAmount.add(getYearTop3CategoryByAcademy.get(getYearTop3CategoryByAcademy.size()-1).getCategoryAmount());
        Map<String,List> temp =  new HashMap<>();
        temp.put("bookCategory",new ArrayList<String>(bookCategory));
        temp.put("readerAcademy",new ArrayList<String>(readerAcademy));
        temp.put("categoryAmount",new ArrayList<Integer>(categoryAmount));
        yearTop3CategoryByAcademy.put(rankFlag,copyList(temp));
        return  yearTop3CategoryByAcademy;
    }
    // 深拷贝代码
    public Map<String, List> copyList(Map<String, List> temp) {
        Map<String, List> result = new HashMap<>();
        for (Map.Entry<String, List> entry : temp.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public Map<String,List> getSingleBookLendTop100(){
        List<Book_Lend> getSingleBookLendTop100 = schoolReportdao.getSingleBookLendTop100();
        Map<String,List> SingleBookLendTop100 = new HashMap<>();

        List<String> bookName = new ArrayList<>();
        List<String> bookAuthor = new ArrayList<>();
        List<String> publisher = new ArrayList<>();
        List<Integer> bookLendTimes = new ArrayList<>();

        for(int i=0;i<getSingleBookLendTop100.size();i++){
            bookName.add(getSingleBookLendTop100.get(i).getBook_name());
            bookAuthor.add(getSingleBookLendTop100.get(i).getBook_author());
            publisher.add(getSingleBookLendTop100.get(i).getPublisher());
            bookLendTimes.add(getSingleBookLendTop100.get(i).getBook_lend_times());
        }

        SingleBookLendTop100.put("bookName",bookName);
        SingleBookLendTop100.put("bookAuthor",bookAuthor);
        SingleBookLendTop100.put("publisher",publisher);
        SingleBookLendTop100.put("bookLendTimes",bookLendTimes);
        return SingleBookLendTop100;
    }
    public Map<String,List> library_report_identity_sum(){
        List<library_report_month_mankinds > library_report_identity_sum = schoolReportdao.getlibrary_identity_sum();
        Map<String,List> library_report_identity_sum_result = new HashMap<>();
        List<String>identity = new ArrayList<>();
        List<Integer>year = new ArrayList<>();
        List<Integer> sum= new ArrayList<>();
        for(int i=0;i<library_report_identity_sum.size();i++){
            if(!year.contains(library_report_identity_sum.get(i).getYear())){
                year.add(library_report_identity_sum.get(i).getYear());
            }
            if(!identity.contains(library_report_identity_sum.get(i).getIdentity())){
                identity.add(library_report_identity_sum.get(i).getIdentity());
            }
            sum.add(library_report_identity_sum.get(i).getSum());
        }
        library_report_identity_sum_result.put("identity",identity);
        library_report_identity_sum_result.put("year",year);
        library_report_identity_sum_result.put("sum",sum);
        return library_report_identity_sum_result;
    }
}