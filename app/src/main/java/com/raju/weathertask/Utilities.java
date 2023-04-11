package com.raju.weathertask;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    public static String dateFormat(int dt){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        Date date =  new Date(dt*1000L);
        String str_date= sdf.format(date);
        return str_date;
    }
    public static String timeFormat(int dt){
        SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm");
        Date date =  new Date(dt*1000L);
        String str_time= sdf.format(date);
        return str_time;
    }
}
