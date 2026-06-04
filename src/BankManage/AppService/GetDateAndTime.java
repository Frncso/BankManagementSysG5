package BankManage.AppService;

import java.time.LocalDate;

public class GetDateAndTime {
    
    public String currentTime(){
        String concatTime = "Date Unavailable";
        
        int day, month, year;
        day = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();
        
        switch(month){
            case 1: 
                return "Jan " + String.valueOf(day) + ", " + String.valueOf(year);
            case 2:
                return "Feb " + String.valueOf(day) + ", " + String.valueOf(year);
            case 3:
                return "Mar " + String.valueOf(day) + ", " + String.valueOf(year);
            case 4:
                return "Apr " + String.valueOf(day) + ", " + String.valueOf(year);
            case 5:
                return "May " + String.valueOf(day) + ", " + String.valueOf(year);
            case 6:
                return "Jun " + String.valueOf(day) + ", " + String.valueOf(year);
            case 7:
                return "Jul " + String.valueOf(day) + ", " + String.valueOf(year);
            case 8:
                return "Aug " + String.valueOf(day) + ", " + String.valueOf(year);
            case 9:
                return "Sept " + String.valueOf(day) + ", " + String.valueOf(year);
            case 10:
                return "Oct " + String.valueOf(day) + ", " + String.valueOf(year);
            case 11:
                return "Nov " + String.valueOf(day) + ", " + String.valueOf(year);
            case 12:
                return "Dec " + String.valueOf(day) + ", " + String.valueOf(year);
        }
        
        return concatTime;
    }
    
}
