package com.company.services_reservas_app.factory;

import org.apache.http.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory {

    public static Date parseDate(String dateString, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateString);
        } catch (Exception e) {
            throw new ParseException("Erro date");
        }
    }
}
