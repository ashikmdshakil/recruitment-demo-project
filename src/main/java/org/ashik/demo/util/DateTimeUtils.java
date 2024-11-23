package org.ashik.demo.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateTimeUtils {

    public static final DateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER_AM_PM = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
    public static final DateTimeFormatter LOCAL_DATE_TIME_MMM_AM_PM = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
    public static final DateTimeFormatter LOCAL_DATE_TIME_MMM = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // use for date to string
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER_YYYY_M_D = DateTimeFormatter.ofPattern("yyyy-M-d"); // use for string to date for safety
    public static final DateTimeFormatter LOCAL_TIME_FORMATTER_AM_PM = DateTimeFormatter.ofPattern("hh:mm:ss a");
    public static final DateTimeFormatter LOCAL_TIME_FORMATTER_HM_AM_PM = DateTimeFormatter.ofPattern("hh:mm a");

    private DateTimeUtils() {
    }

    /**
     * This method used convert string to date
     *
     * @param str String date value
     * @return date Date
     */
    public static Date strToDt(String str) {
        Date dt = null;
        try {
            if (str != null) {
                dt = DATA_FORMAT.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static LocalDateTime strToLocalDt(String str) {
        LocalDateTime dt = null;
        try {
            if (str != null) {
//                dt = DATA_FORMAT.parse(str);
                dt = LocalDateTime.parse(str, LOCAL_DATE_TIME_FORMATTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }


    public static LocalDate strToLocalDate(String str) {
        LocalDate dt = null;
        try {
            if (str != null) {
                dt = LocalDate.parse(str, LOCAL_DATE_FORMATTER_YYYY_M_D);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }

    /**
     * This method used convert date to string
     *
     * @param dt date
     * @return string Date
     */
    public static String dtToStr(Date dt) {
        String str = null;
        if (dt != null) {
            str = DATA_FORMAT.format(dt);
        }
        return str;
    }

    /**
     * This method used convert date to string
     *
     * @param dt date
     * @return string Date
     */
    public static String localDtToStr(LocalDateTime dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_TIME_FORMATTER.format(dt);
        }
        return str;
    }

    /**
     * This method used convert date to string
     *
     * @param dt date
     * @return string Date
     */
    public static String localDtToStrHourMin(LocalDateTime dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_TIME_FORMATTER_HM_AM_PM.format(dt);
        }
        return str;
    }


    /**
     * @param dt
     * @return
     */
    public static String localDtToStrAMPM(LocalDateTime dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_TIME_FORMATTER_AM_PM.format(dt);
        }
        return str;
    }

    /**
     * @param dt
     * @return
     */
    public static String localDtToStrMMMAMPM(LocalDateTime dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_TIME_MMM_AM_PM.format(dt);
        }
        return str;
    }

    public static String localDtToStrMMM(LocalDateTime dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_TIME_MMM.format(dt);
        }
        return str;
    }

    public static String localDtToStrMMM(LocalDate dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_TIME_MMM.format(dt);
        }
        return str;
    }


    /**
     * This method used convert date to string
     *
     * @param dt date
     * @return string Date
     */
    public static String localDtToStr(LocalDate dt) {
        String str = null;
        if (dt != null) {
            str = LOCAL_DATE_FORMATTER_YYYY_MM_DD.format(dt);
        }
        return str;
    }
    public static LocalDate StrTolocalDt(String dt) {
        LocalDate str = null;
        if (dt != null) {
//            str = LOCAL_DATE_FORMATTER_YYYY_MM_DD.format(dt);
            str = LocalDate.parse(dt, LOCAL_DATE_FORMATTER_YYYY_MM_DD);
        }
        return str;
    }

    /**
     * 24 format time validation
     *
     * @param time
     * @return
     */
    public static boolean isValidTime24Format(String time) {
        // Regex to check valid time in 24-hour format.
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the time is empty
        // return false
        if (time == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given time
        // and regular expression.
        Matcher m = p.matcher(time);

        // Return if the time
        // matched the ReGex
        return m.matches();

    }

    // input value is dd-MMM-yyyy [01-APR-2023]
    // output : 01-Apr-2023
    public static String capitalizedMonthName(String dateText) {
        if (dateText == null) {
            return null;
        }

        String[] arrDate = dateText.split("-");
        String month = StringUtils.capitalize(arrDate[1].toLowerCase()); // get the remaining letters

        return arrDate[0] + "-" + month + "-" + arrDate[2];
    }

    public static String convertTime24ToTime12(String time24) {
        if (isValidTime24Format(time24)) {
            LocalTime localTime = LocalTime.parse(time24);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            return localTime.format(dateTimeFormatter);
        }
        return null;
    }

    public static boolean isBetween(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        return dateToCheck.isAfter(startDate) && dateToCheck.isBefore(endDate);
    }

    public static boolean isBetweenOrEqual(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        return (dateToCheck.isEqual(startDate) || dateToCheck.isEqual(endDate))
                || (dateToCheck.isAfter(startDate) && dateToCheck.isBefore(endDate));
    }

    public static boolean isAfterOrEqual(LocalDate dateToCheck, LocalDate inputDate) {
        return dateToCheck.isAfter(inputDate) || dateToCheck.isEqual(inputDate);
    }

    public static boolean isBeforeOrEqual(LocalDate dateToCheck, LocalDate inputDate) {
        return dateToCheck.isBefore(inputDate) || dateToCheck.isEqual(inputDate);
    }

}
