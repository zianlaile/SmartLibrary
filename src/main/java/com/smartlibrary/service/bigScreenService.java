package com.smartlibrary.service;

import com.smartlibrary.dao.bigScreenDao;
import com.smartlibrary.domain.BigScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/9/11.
 */
@Service
public class bigScreenService {
    @Autowired
    private bigScreenDao bigscreendao;
    public Map<String, String> getNumber(){
        Map<String,String> number = new HashMap<String,String>();
        List<BigScreen> bigScreenList= bigscreendao.getnumber();
        for(int i=0;i<bigScreenList.size();i++){
            if (bigScreenList.get(i).getName().equals("all_gctrl")){
                number.put("all_gctrl",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_lend")){
                number.put("all_lend",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_print")){
                number.put("all_print",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_book")){
                number.put("all_book",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_seats")){
                number.put("all_seats",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("now_seats")){
                number.put("now_seats",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_crooms")){
                number.put("all_crooms",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("now_crooms")){
                number.put("now_crooms",bigScreenList.get(i).getCount());
            }
        }
        return number;
    }
    public Map<String, String> getIcpremonth(){
        Map<String,String> number = new HashMap<String,String>();
        List<BigScreen> bigScreenList= bigscreendao.getnumber();
        for(int i=0;i<bigScreenList.size();i++){
            if (bigScreenList.get(i).getName().equals("premonth_seats")){
                number.put("premonth_seats",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("premonth_crooms")){
                number.put("premonth_crooms",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("premonth_ereads")){
                number.put("premonth_ereads",bigScreenList.get(i).getCount());
            }
        }
        return number;
    }
    public Map<String, String> getPrintpremonth(){
        Map<String,String> number = new HashMap<String,String>();
        List<BigScreen> bigScreenList= bigscreendao.getnumber();
        for(int i=0;i<bigScreenList.size();i++){
            if (bigScreenList.get(i).getName().equals("premonth_print_p")){
                number.put("premonth_print_p",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("premonth_print_c")){
                number.put("premonth_print_c",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("premonth_print_s")){
                number.put("premonth_print_s",bigScreenList.get(i).getCount());
            }
        }
        return number;
    }
    public Map<String, String> getRating(){
        Map<String,String> number = new HashMap<String,String>();
        List<BigScreen> bigScreenList= bigscreendao.getnumber();
        for(int i=0;i<bigScreenList.size();i++){
            if (bigScreenList.get(i).getName().equals("now_seats")){
                number.put("now_seats",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_seats")){
                number.put("all_seats",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("now_crooms")){
                number.put("now_crooms",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_crooms")){
                number.put("all_crooms",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("now_ereads")){
                number.put("now_ereads",bigScreenList.get(i).getCount());
            }
            else if (bigScreenList.get(i).getName().equals("all_ereads")){
                number.put("all_ereads",bigScreenList.get(i).getCount());
            }
        }
        return number;
    }
    public Map<String, List> getLend(){
        Map<String,List> lenddata = new HashMap<String,List>();
        List<BigScreen> bigScreenList= bigscreendao.getlend();
        List<String> hour = new ArrayList<String>();
        List<String> lend = new ArrayList<String>();
        for(int i=0;i<bigScreenList.size();i++){
            hour.add(bigScreenList.get(i).getHour());
            lend.add(bigScreenList.get(i).getLend());
        }
        lenddata.put("hour",hour);
        lenddata.put("lend",lend);
        return lenddata;
    }
    public Map<String, List> getResource(){
        Map<String,List> resourcedata = new HashMap<String,List>();
        List<BigScreen> bigScreenList= bigscreendao.getresource();
        List<String> hour = new ArrayList<String>();
        List<String> lend = new ArrayList<String>();
        List<String> gctrl = new ArrayList<String>();
        List<String> print = new ArrayList<String>();
        List<String> seats = new ArrayList<String>();
        List<String> crooms = new ArrayList<String>();
        List<String> ereads = new ArrayList<String>();
        for(int i=6;i<bigScreenList.size()-2;i++){
            hour.add(bigScreenList.get(i).getHour());
            lend.add(bigScreenList.get(i).getLend());
            gctrl.add(bigScreenList.get(i).getGctrl());
            print.add(bigScreenList.get(i).getPrint());
            seats.add(bigScreenList.get(i).getSeats());
            crooms.add(bigScreenList.get(i).getCrooms());
            ereads.add(bigScreenList.get(i).getEreads());
        }
        resourcedata.put("hour",hour);
        resourcedata.put("lend",lend);
        resourcedata.put("gctrl",gctrl);
        resourcedata.put("print",print);
        resourcedata.put("seats",seats);
        resourcedata.put("crooms",crooms);
        resourcedata.put("ereads",ereads);
        return resourcedata;
    }
}
