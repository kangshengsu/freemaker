package com.fm.framework.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/10/10 23:33
 */
public class NumberUtil {

    /**
     * 保留小数多少位
     * @param data
     * @param limit
     * @return
     */
    public static Double formatDouble(Double data,int limit){

        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留位小数
        nf.setMaximumFractionDigits(limit);
        //四舍五入
        //nf.setRoundingMode(RoundingMode.HALF_UP);

        return Double.valueOf(nf.format(data));
    }

    public static String formantBigDecimal(BigDecimal data){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return  decimalFormat.format(data);
    }

    public static void main(String[] args) {
        System.out.println(formatDouble(Double.valueOf("4.95"),2));
        System.out.println(formatDouble(Double.valueOf("4.94"),2));
        System.out.println(formatDouble(Double.valueOf("4.96"),2));
        System.out.println(formantBigDecimal(BigDecimal.valueOf(5.00)));


    }
}
