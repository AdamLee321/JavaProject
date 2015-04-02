package gui;

import java.util.Calendar;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)

This class is for generation of correct dates for ComboBoxes,
It returns String arrays of months, past 100 years (-16),
and correct number of days... meaning days correctly reflect leap years and months
*/

public class DateGenerator {

    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public String[] getMonthDays(int monthIn, int yearIn){

        int numDays = 0;
        int counter = 0;

        switch (monthIn) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays = 30;
                break;
            case 2:
                if (((yearIn % 4 == 0) && !(yearIn % 100 == 0)) || (yearIn % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:
                break;
        }

        String[] days = new String[numDays];

        for (int i = 0; i < numDays; i++) {
            days[i] = Integer.toString(i+1);
        }

        return days;
    }

    public String[] getMonths(){
        return months;
    }

    public String[] getPastCentury() {
        String[] years = new String[101];

        Calendar cal = Calendar.getInstance();
        int thisYear = cal.get(Calendar.YEAR);
        int legalYear = thisYear - 16;  // no members or employees below 16

        for (int i = 0; i < years.length; i++) {
            years[i] = Integer.toString(legalYear -  i);
        }
        return years;
    }
}