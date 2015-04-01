package gui;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 01/04/2015)
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidator {

    public static boolean isEmptyField(String field) {
        if (field.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isEmptyPassField(char[] pw){
        if (pw.length == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isValidEmail(String email){

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            return true;
        } else {
            return false;
        }
    }
    // http://howtodoinjava.com/2014/11/11/java-regex-validate-email-address/

    public static boolean isNumber(String string) {
        try {
            Long.parseLong(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}