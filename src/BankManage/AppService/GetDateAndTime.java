package BankManage.AppService;

import java.time.LocalDate;
import java.time.LocalTime;

public class GetDateAndTime {
    
    public String currentTime(){
        String concatTime = "Date Unavailable";
        
        int day, month, year;
        day = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();
        
        int hour, minute, second;
        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        second = LocalTime.now().getSecond();
        
        switch(month){
            case 1: 
                return "Jan " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 2:
                return "Feb " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 3:
                return "Mar " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 4:
                return "Apr " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 5:
                return "May " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 6:
                return "Jun " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 7:
                return "Jul " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 8:
                return "Aug " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 9:
                return "Sept " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 10:
                return "Oct " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 11:
                return "Nov " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
            case 12:
                return "Dec " + String.valueOf(day) + ", " + String.valueOf(year) + " | " + hour + ":" + minute + ":" + second;
        }
        
        return concatTime;
    }
    
    public String requestTime(){
        String concatTime;
        
        int day, month, year;
        day = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();
        
        int hour, minute, second;
        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        second = LocalTime.now().getSecond(); 
        
        concatTime = (year+"-"+month+"-"+day+"-"+hour+minute+second);
        
        return concatTime;
    }
    
}
