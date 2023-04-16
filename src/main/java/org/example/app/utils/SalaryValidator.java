package org.example.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class SalaryValidator {
    public static boolean isValid(double value) {

        String regex = "^(\\d{1,9})([.]*)([0-9]{0,2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Double.toString(value));
        return matcher.matches();
    }
}
