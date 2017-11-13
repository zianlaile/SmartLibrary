package com.smartlibrary;

import java.util.Scanner;

/**
 * 大数乘法的简单实现, 目前还不是很完善
 * Fix:
 * 1. 修改前后删除0的一些错误情况
 * 2. 支持负数运算
 * 3. 判断输入字符串是否符合小数定义, 用正则表达式判断
 * @author icejoywoo
 * @since 2012.2.16
 * @version 0.1.1
 */
public class BigNumber {
    public static void main(String[]args){
        int a,numOfAddend,sum=0;
        String str="";
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        numOfAddend = scanner.nextInt();
        StringBuffer[] addend=new StringBuffer[numOfAddend];//一字符串形式储存加数
        for(int i=0 ; i<addend.length;i++)//初始化
            addend[i]=new StringBuffer();
        for(int i=0;i<addend.length;i++)
            for(int j=0;j<=i;j++)
                addend[i].append(a);
        //以字符串形式建立等式
        for(int i=0;i<addend.length;i++){
            if(i!=0)str+="+";
            str+=addend[i].toString();
        }
        //计算等式左端
        for(int i=0;i<addend.length;i++)
            sum+=Integer.parseInt(addend[i].toString());
        System.out.println(sum);
    }
}