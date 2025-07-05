package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    private FormatDate(){
        
    }
    public static String toFr(LocalDate date){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        return  date.format(formatter);
    }

    public static String toEn(LocalDate date){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        return  date.format(formatter);
    }
}
