package com.smartlibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
   public static void main(String[] args) throws IOException {
        System.out.println("Input two large integers:");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = buffer.readLine().split(" ");
        System.out.println(bigNumberMultiply(strArray[0].concat(".0"), strArray[1]));
    }
/*   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input two large integers:");
        String num1 = scanner.next();
        String num2 = scanner.next();
        System.out.println(bigNumberMultiply(num1, num12));
        scanner.close();
    }*/
    /**
     * 计算两个任意大小和精度的数的乘积
     * @param first 第一个参数
     * @param second 第二个参数
     * @return 两个数的乘积
     */
    private static String bigNumberMultiply(String first, String second) {
        // 正负号判断标志
        boolean flag = false;
        if (first.charAt(0) == '-') {
            flag = !flag;
            first = first.substring(1);
        }
        if (second.charAt(0) == '-') {
            flag = !flag;
            second = second.substring(1);
        }
        // 小数点的位置
        int aPoints = first.length()-first.indexOf('.')-1;
        int bPoints = second.length()-second.indexOf('.')-1;
        int pointPos = aPoints + bPoints; // 结果的小数点位置
        // 删除小数点
        StringBuffer aBuffer = new StringBuffer(first.replaceAll("\\.", ""));
        StringBuffer bBuffer = new StringBuffer(second.replaceAll("\\.", ""));
        int[] a = string2IntArray(aBuffer.toString());
        int[] b = string2IntArray(bBuffer.toString());
        int[] result = new int[a.length + b.length-1]; // 保存结果的数组
        // 计算
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }
        // result中的某一位大于9的话需要进位
        for (int i = result.length-1; i >= 0;--i) {
            if (result[i] > 9) {
                result[i-1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }
        StringBuffer buffer = new StringBuffer(); // 将result数组转换为字符串
        for (int i = 0; i < result.length; ++i) {
            // 添加小数点
            if(result.length-i == pointPos) {
                buffer.append(".");
            }
            buffer.append(String.valueOf(result[i]));
        }
        if (buffer.indexOf(".") != -1)
        {
            // 删除最开始的0
            int i = 0;
            while (i < buffer.length()) {
                if (buffer.length() > 2 && buffer.charAt(i+1) == '.') { // 小数点前只有一个数 0.
                    break;
                } else if (buffer.charAt(i) == '0') { // 删除最前边的0
                    buffer.deleteCharAt(i);
                    i = 0;
                    continue;
                } else { // 当第一位不是0的时候
                    break;
                }
            }
            // 删除末尾的0
            i = buffer.length()-1;
            while (i >= 0) {
                if (buffer.length() > 2 && buffer.charAt(i-1) == '.') { // 小数点后直接是数字
                    break;
                } else if (buffer.charAt(i) == '0') { // 删除末尾的0
                    buffer.deleteCharAt(i);
                    i = buffer.length()-1;
                    continue;
                } else { // 当最后一位不是0的时候
                    break;
                }
            }
        }
        // 根据符号位, 返回值的正负标志
        if (flag) {
            return "-" + buffer.toString();
        } else {
            return buffer.toString();
        }
    }
    /**
     * 将字符串装换为数组
     * @param number
     * @return
     */
    private static int[] string2IntArray(String number) {
        // 判断输入是否符合浮点数的要求
        Pattern pattern = Pattern.compile("^(-?\\d+|\\d*)\\.?\\d*$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.find()) {
        throw new IllegalArgumentException("输入的数不正确!");
        }
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
        result[i] = (int) (number.charAt(i)-'0');
        }
        return result;
        }
        }