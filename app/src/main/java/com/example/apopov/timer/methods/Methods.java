package com.example.apopov.timer.methods;

public class Methods {


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

}
