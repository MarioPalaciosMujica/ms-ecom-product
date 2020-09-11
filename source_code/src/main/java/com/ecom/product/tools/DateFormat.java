package com.ecom.product.tools;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateFormat {

    private String format = "dd/MM/yyyy HH:mm:ss";
    private DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

    public String dateTimeToString(DateTime date){
        if(date != null){
            return date.toString(format);
        }
        else {
            return null;
        }
    }

    public DateTime StringToDateTime(String text){
        if(text != null){
            return formatter.parseDateTime(text);
        }
        else {
            return null;
        }
    }

    public DateTime datePickerToDateTime(String datePicker){
        if(datePicker != null){
            String[] dateArray = datePicker.split("-");
            DateTime date = new DateTime().withDate(
                    Integer.parseInt(dateArray[0]),
                    Integer.parseInt(dateArray[1]),
                    Integer.parseInt(dateArray[2])
            ).withTime(0, 0, 0, 0);
            return date;
        }
        else {
            return null;
        }
    }

}
