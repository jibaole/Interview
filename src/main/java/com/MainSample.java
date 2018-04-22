package com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/16
 */

public class MainSample {
    public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        System.out.println( timeMillis );
        System.out.println( transferLongToDate(timeMillis) );
    }


    /**
     * 把long 转换成 日期 再转换成String类型
     */
    public static String transferLongToDate(Long millSec) {
        Date date = new Date(millSec);
        return yyyyMMddHHmmss.format(date);
    }
}
