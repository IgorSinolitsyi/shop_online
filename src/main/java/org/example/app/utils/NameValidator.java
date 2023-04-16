package org.example.app.utils;

public class NameValidator {
    public static boolean isValid(String value) {
       return  (value.length()>=3 && value.length()<=45);
    }
}
