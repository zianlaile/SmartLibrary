package com.smartlibrary;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class DemoAsm{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String str  = sc.next();
        char[] chs = str.toCharArray();
        for (char c: chs) {
           if(!(c>='0'&&c<='9'||c>='a'&&c<='z'||c<='Z'&&c>='A')){
               System.out.print("输入不合法！");
               return;
           }
        }
        Map<Character ,Integer> map = new TreeMap<Character, Integer>();
        for (int i = 0; i < chs.length; i++) {
            char key = chs[i];
            if(map.containsKey(key)){
                Integer value = map.get(key);
                value = value+1;
                map.put(key, value);
            }else{
                map.put(key, 1);
            }
        }
        for (Character key : map.keySet()) {
            System.out.println(key+"的出现次数:"+map.get(key));
        }
    }
}