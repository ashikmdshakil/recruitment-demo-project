package org.ashik.demo.util;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.springframework.util.StringUtils {

    public static String convertString(Long value) {
        return value != null ? value.toString() : null;
    }

    public static String convertString(Integer value) {
        return value != null ? value.toString() : null;
    }

    /**
     * convert underscore string to camel case string
     *
     * @param uStr :: underscore string
     * @return camel case string
     */

    public static boolean isValidMobileNumber(String mobileNo) {
        // Regex to check valid mobile number.
        String regex = "^(?:\\+88|88)?(01[3-9]\\d{8})$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the mobile number is empty
        // return false
        if (mobileNo == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given mobile number
        // and regular expression.
        Matcher m = p.matcher(mobileNo);

        // Return if the mobile number
        // matched the ReGex
        return m.matches();

    }

    public static boolean containsWords(String inputString, String[] items) {
        boolean found = true;
        if (inputString == null || items == null || items.length == 0) {
            return false;
        }
        for (String item : items) {
            if (!inputString.contains(item)) {
                found = false;
                break;
            }
        }
        return found;
    }

    public static String convertToString(Object input) {
        if (Objects.isNull(input) || input.equals("null") || input.equals("")) {
            return "";
        }
        return String.valueOf(input);
    }

    public static String changeChassisToAsterisk(String chassisNo) {
        if (StringUtils.hasText(chassisNo) && chassisNo.length() > 4) {
            return chassisNo.substring(0, chassisNo.length() - 4) + "****";
        }
        return chassisNo;
    }

    public static String replaceNonAsciiChar(String applicantNameEng) {
        return applicantNameEng.replaceAll("[^\\x20-\\x7F]", "");
    }

    public static String getFirstPartSplit(String input) {
        String[] tokens = input.split(" ", 2);
        return tokens[0];
    }

    public static String getLastPartSplit(String input) {
        String[] tokens = input.split(" ", 2);
        return tokens[1];
    }

}
