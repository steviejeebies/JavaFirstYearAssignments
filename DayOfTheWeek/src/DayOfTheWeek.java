import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek {

    public static final int FEBRUARY_MONTH_VALUE = 2;
    public static final int DAYS_OF_WEEK = 7;
    public static final int ORDINAL_DAY_VALUE_DIVISION = 10;
    public static final int FIRST_OR_LAST_DIGITS_YEAR_DIVISION = 100;
    public static final int ORDINAL_ELEVENTH = 11;
    public static final int ORDINAL_TWELFTH = 12;

//following constants required for functions from Blackboard, credited below

    public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
    public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
    public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
    public static final int DAYS_IN_MOST_MONTHS = 31;
    public static final int NUMBER_OF_MONTHS = 12;


    public static void main(String[] args) {

        try
        {
            String userInput = JOptionPane.showInputDialog("Enter your date numerically "
                    + "in the form \"Day/Month/FullYear\":");
            Scanner inputScanner = new Scanner(userInput);
            inputScanner.useDelimiter("/");


            int day = inputScanner.nextInt();
            int month = inputScanner.nextInt();
            int year = inputScanner.nextInt();

            if(validDate(day, month, year))
            {
                String numberEnding = numberEnding(day);
                String monthName = monthName(month);
                String dayOfTheWeek = dayOfTheWeek(day, month, year);

                JOptionPane.showMessageDialog(null, dayOfTheWeek + ", " + day
                        + numberEnding + " " + monthName + " " + year);

                inputScanner.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This is not a valid date.");
            }
        }
        catch(java.util.NoSuchElementException e)
        {
            JOptionPane.showMessageDialog(null,
                    "You have inputted your date incorrectly.");
        }
        catch(NullPointerException e)
        {

        }

    }

    public static String numberEnding(int dayNumber){

        dayNumber =
                (dayNumber == ORDINAL_ELEVENTH || dayNumber == ORDINAL_TWELFTH)
                        ? dayNumber : (dayNumber %= ORDINAL_DAY_VALUE_DIVISION);

        /* above assignment is required as 11th and 12th are exceptions, don't
         * follow general ordinal number rules. If dayNumber is not 11 or 12,
         * then we find mod 10 of dayNumber to get its last digit.
         */

        String numberEnding;

        switch(dayNumber){
            case 1:
                numberEnding = "st";
                break;
            case 2:
                numberEnding = "nd";
                break;
            case 3:
                numberEnding = "rd";
                break;
            default:
                numberEnding = "th";
        }

        return numberEnding;
    }

    public static String monthName(int month){
        String monthName = "";

        switch(month){
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }

        return monthName;
    }

    public static String dayOfTheWeek(int day, int month, int year){

        String dayOfTheWeek = "";

        if(month <= FEBRUARY_MONTH_VALUE)
        {
            year--;
        }

        int firstTwoDigitsOfYear = year / FIRST_OR_LAST_DIGITS_YEAR_DIVISION;
        int lastTwoDigitsOfYear = year % FIRST_OR_LAST_DIGITS_YEAR_DIVISION;
        int firstFloorValueForEquation =
                (int) (2.6 * (((month + 9) % 12) + 1) -0.2);
        int secondFloorValueForEquation = (int) lastTwoDigitsOfYear/4;
        int thirdFloorValueForEquation = (int) firstTwoDigitsOfYear/4;

        int dayOfTheWeekValue = (day + firstFloorValueForEquation
                + lastTwoDigitsOfYear + secondFloorValueForEquation
                + thirdFloorValueForEquation - 2 * (firstTwoDigitsOfYear))
                % DAYS_OF_WEEK;

        dayOfTheWeekValue = (dayOfTheWeekValue < 0)
                ? (dayOfTheWeekValue + DAYS_OF_WEEK) : dayOfTheWeekValue;

        /* dayOfTheWeekValue must be positive, but just finding the absolute value of
         * negative values will produce those given days in reverse order. To solve
         * this, simply adding 7, i.e. the number of days in the week, will produce
         * the correct day value for values less than 0.
         */

        switch(dayOfTheWeekValue)
        {
            case 0:
                dayOfTheWeek = "Sunday";
                break;
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
        }

        return dayOfTheWeek;
    }

    /* The following three functions are taken from "ValidDate.java" from Week 9
     * on Blackboard. Their purpose in this code is to ensure that the date entered
     * by the user is valid, and this is tested (in main) before changing the
     * date format.
     */

    public static boolean validDate(int day, int month, int year)
    {
        return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
                (day >= 1) && (day <= daysInMonth( month, year )));
    }

    public static int daysInMonth(int month, int year)
    {
        int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
        switch (month)
        {
            case 2:
                numberOfDaysInMonth = isLeapYear(year)
                        ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR
                        : DAYS_IN_FEBRUARY_NORMALLY;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
                break;
            default:
                numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
                break;
        }
        return numberOfDaysInMonth;
    }

    public static boolean isLeapYear( int year )
    {
        return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
    }

}
