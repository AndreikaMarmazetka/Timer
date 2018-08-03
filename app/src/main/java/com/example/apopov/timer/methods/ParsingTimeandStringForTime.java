package com.example.apopov.timer.methods;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParsingTimeandStringForTime {


    public String StringForTextViewTimer(int progress, int hours){
        String formatTimer;
        int  minutes;
        int seconds;
        minutes= progress/6;
        seconds = (progress%6)*10;
        String sSecond;
        if (progress==360)
        {
            minutes=0;
        }
        if(seconds <10){
            sSecond =  "0"+ String.valueOf(seconds);
        }
        else {
            sSecond= String.valueOf(seconds);
        }

        if(hours == 0 ){
            formatTimer =String.valueOf(minutes)+ ":"+ sSecond;
        }
        else {
            if(minutes<10) {
                formatTimer = String.valueOf(hours) + ":0" + String.valueOf(minutes) + ":" + sSecond;
            }
            else{
                formatTimer = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + sSecond;
            }
        }

        return formatTimer;
    }

    public Time parsingTime (String str){

        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Time time;
        try {
            time = new Time(dateFormat.parse(str).getTime());
        } catch (ParseException e) {
            time =  new Time(new Date(0L).getTime());
        }
        return time;
    }

}
