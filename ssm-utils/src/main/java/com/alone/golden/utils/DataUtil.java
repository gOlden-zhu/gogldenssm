package com.alone.golden.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:_AloneBoy
 * @date:2019/10/25
 * 时间和字符串互相转化工具类
 */
public class DataUtil {

    //Date2String
    public static String data2String(Date data,String patt){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        return simpleDateFormat.format(data);
    }

    //String2Date
    public static Date string2Date(String date,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        return simpleDateFormat.parse(date);
    }
}
