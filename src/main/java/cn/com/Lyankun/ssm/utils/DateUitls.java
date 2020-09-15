package cn.com.Lyankun.ssm.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//将yyyy/MM/dd HH:mm:ss格式字符串--------->java.untl.Date
public class DateUitls {
    private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static Date strDate(String datStr){
        try {
            return sdf.parse(datStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
