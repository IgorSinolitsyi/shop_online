package org.example.app.utils;

public  class DateValidator {

    public static boolean isValid(java.sql.Date value) {
        return  value.toLocalDate().getYear()>1940 && value.toLocalDate().getYear()<2010;
    }
}
