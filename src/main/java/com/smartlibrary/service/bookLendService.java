package com.smartlibrary.service;

import com.smartlibrary.dao.bookLendDao;
import com.smartlibrary.domain.Book_Lend;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by tt on 2017/7/17.
 */
@Service
public class bookLendService {
    private static final Logger logger = Logger.getLogger(bookLendService.class);
    @Autowired
    private bookLendDao booklenddao;


    public Map<String,List> getBorrowCountByYear(Book_Lend b) {
        List<Book_Lend> year= booklenddao.getBorrowCountByYear(b);
        ArrayList<Integer> lend_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<year.size();i++){
            lend_times.add(year.get(i).getBook_lend_times());
            times.add(String.valueOf(year.get(i).getYear()));
        }
        data.put("lend_times",lend_times);
        data.put("times",times);
        return data;
    }

    public Map<String ,List>  getBorrowCountByMonth(Book_Lend b){
        List<Book_Lend> month= booklenddao.getBorrowCountByMonth(b);
        Book_Lend bl;
        ArrayList<Integer> lend_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<month.size();i++){
            bl=month.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"/"+String.valueOf(bl.getMonth()));
            //组成返回对象X轴与Y轴
            lend_times.add(month.get(i).getBook_lend_times());
            times.add(month.get(i).getTime());
        }
        data.put("lend_times",lend_times);
        data.put("times",times);
        return data;
    }

    public Map<String ,List>  getBorrowCountByDay(Book_Lend b){
        List<Book_Lend> day= booklenddao.getBorrowCountByDay(b);
        Book_Lend bl;
        ArrayList<Integer> lend_times=new  ArrayList<Integer>();
        ArrayList<String> times=new  ArrayList<String>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<day.size();i++){
            bl=day.get(i);
            bl.setTime(String.valueOf(bl.getYear())+"/"+String.valueOf(bl.getMonth())+"/"+String.valueOf(bl.getDay()));
            //组成返回对象X轴与Y轴
            lend_times.add(day.get(i).getBook_lend_times());
            times.add(day.get(i).getTime());
        }
        data.put("lend_times",lend_times);
        data.put("times",times);
        return data;
    }

    public    Map<Integer, HashMap<String ,List>> getBorrowCountByHourAndAcademy(Book_Lend b){
        List<Book_Lend> hourandacademy= booklenddao.getBorrowCountByHourAndAcademy(b);
        Set hour=new TreeSet();//取不同的时间
        for(int i=0;i<hourandacademy.size();i++){
            hour.add(hourandacademy.get(i).getHour());
        }
        Iterator<Integer> hourit = hour.iterator();
        Map<Integer, HashMap<String ,List>> map = new TreeMap<Integer, HashMap<String ,List>>();
        while (hourit.hasNext()) {
            int  onehour = hourit.next();
            ArrayList<String> academy=new  ArrayList<String>();
            ArrayList<Integer> lend_times=new  ArrayList<Integer>();
            ArrayList<Integer> book_back_times=new  ArrayList<Integer>();
            HashMap<String ,List> data=new HashMap<String ,List>();
            for (int i = 0; i < hourandacademy.size(); i++) {
                if(hourandacademy.get(i).getHour()==onehour){
                    academy.add(hourandacademy.get(i).getAcademy());
                    lend_times.add(hourandacademy.get(i).getBook_lend_times());
                    book_back_times.add(hourandacademy.get(i).getBook_back_times());
                }
            }
            data.put("academy",academy);
            data.put("book_lend_times",lend_times);
            data.put("book_back_times",book_back_times);
            map.put(onehour,data);
        }
        return map;
    };
    public   Map<String ,List>  getBorrowCountByHourAndBookkinds(Book_Lend b){
        Map<String ,List> data=new HashMap<String ,List>();
        List<Book_Lend> hourandbookkinds= booklenddao.getBorrowCountByHourAndBookkinds(b);
        Set academy=new TreeSet();
        Set bookkinds=new TreeSet();
        for(int i=0;i<hourandbookkinds.size();i++){
            academy.add(hourandbookkinds.get(i).getAcademy());
            bookkinds.add(hourandbookkinds.get(i).getBook_kind());
        }
        Iterator<String> academyit = academy.iterator();
        Iterator<String> bookkindsit = bookkinds.iterator();
        ArrayList<ArrayList<Double>> abc=new  ArrayList<ArrayList<Double>>();
        ArrayList<String> academylist=new  ArrayList<String>();
        ArrayList<String> bookkindslist=new  ArrayList<String>();

        for (int i=0;academyit.hasNext();i++) {
            String  Sacademy = academyit.next();
            academylist.add(Sacademy);
        }
        for (int j=0;bookkindsit.hasNext();j++) {
            String  Sbookkind = bookkindsit.next();
            bookkindslist.add(Sbookkind);
        }

        for (int i=0;i<academylist.size();i++) {
            String  Sacademy = academylist.get(i);
            //System.out.println("Sacademy------------------"+Sacademy);
            ArrayList<  ArrayList<Double>> bc=new  ArrayList<  ArrayList<Double>>();
            for (int j=0;j<bookkindslist.size();j++) {
                String  Sbookkind = bookkindslist.get(j);
                //System.out.println("Sbookkind------"+Sbookkind);
                ArrayList<Double> c=new  ArrayList<Double>();
                for (int k = 0; k < hourandbookkinds.size(); k++) {
                    if(Sbookkind.equals(hourandbookkinds.get(k).getBook_kind())&&Sacademy.equals(hourandbookkinds.get(k).getAcademy())){
                        double ii=i;
                        double jj=j;
                        c.add(ii);
                        c.add(jj);
                        if(hourandbookkinds.get(k).getBook_lend_w()<0.001)
                        {
                        c.add(0.0);
                        }else {
                            c.add(hourandbookkinds.get(k).getBook_lend_w());
                        }
                    }
                }
                bc.add(c);
            }
            abc.addAll(bc);
        }
        data.put("academy",academylist);
        data.put("bookkindslist",bookkindslist);
        data.put("data",abc);
        return data;
    };

    public Map<String ,List> getBorrowCountBySexAndBookkinds(Book_Lend b){
        List<Book_Lend> sexAndbookkinds= booklenddao.getBorrowCountBySexAndBookkinds(b);
        Map<String ,List> data=new HashMap<String ,List>();
        ArrayList<Map> manAndwoman=new  ArrayList<Map>();


        Set onemonth=new TreeSet();
        Set bookkinds=new TreeSet();

        Map<Integer ,List> man=new HashMap<Integer ,List>();
        Map<Integer ,List> woman=new HashMap<Integer ,List>();

        for(int i=0;i<sexAndbookkinds.size();i++){
            onemonth.add(sexAndbookkinds.get(i).getMonth());
            bookkinds.add(sexAndbookkinds.get(i).getBook_kind());
        }

        Iterator<Integer> onemonthit = onemonth.iterator();
        ArrayList<Integer> monthlist=new  ArrayList<Integer>();

        Iterator<String> bookkindsit = bookkinds.iterator();
        ArrayList<String> bookkindslist=new  ArrayList<String>();

       while(onemonthit.hasNext()) {
            int  month =onemonthit.next();

            monthlist.add(month);
        }

        while(bookkindsit.hasNext()) {
            String  kind =bookkindsit.next();
            bookkindslist.add(kind);
        }

        for (int j = 0; j < monthlist.size(); j++) {
            int month =monthlist.get(j);
            ArrayList<Integer> mandata=new  ArrayList<Integer>();
            ArrayList<Integer> womandata=new  ArrayList<Integer>();
            for (int k = 0; k < sexAndbookkinds.size(); k++) {
                if(month==sexAndbookkinds.get(k).getMonth()){
                    mandata.add(sexAndbookkinds.get(k).getM_book_lend_times());
                    womandata.add(sexAndbookkinds.get(k).getF_book_lend_times());
                }
            }
            man.put(month,mandata);
            woman.put(month,womandata);
        }
        manAndwoman.add(man);
        manAndwoman.add(woman);
        data.put("manAndwoman",manAndwoman);
        data.put("bookkindslist",bookkindslist);
        data.put("monthlist",monthlist);

        return data;
    }

    public Map<String ,List> getBorrowCountByPublisher(Book_Lend b){
        List<Book_Lend> publish= booklenddao.getBorrowCountByPublisher(b);
        ArrayList<String> publisher=new  ArrayList<String>();
        ArrayList<Integer> times=new  ArrayList<Integer>();
        Map<String ,List> data=new HashMap<String ,List>();
        for(int i=0;i<publish.size();i++){
            publisher.add(publish.get(i).getPublisher());
            times.add(publish.get(i).getBook_lend_times());
        }
        data.put("publisher",publisher);
        data.put("times",times);
        return data;
    };
}
