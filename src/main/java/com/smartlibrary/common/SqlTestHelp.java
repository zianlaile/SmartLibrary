package com.smartlibrary.common;

import org.apache.log4j.Logger;

public class SqlTestHelp {
    private static final Logger logger = Logger.getLogger(SqlTestHelp.class);

    public static boolean isInList(String s,String[] list){
        for(int i=0;i<list.length;i++){
            if(s.trim().equals(list[i].trim()))
                return true;
        }
        return false;
    }



}
