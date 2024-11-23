package org.ashik.demo.util;


import java.io.Serializable;

public class NullHandlerUtils implements Serializable {
    private static final long serialVersionUID = 1L;


    public static String removeNull(String inputStr) {
        if (inputStr == null) {
            inputStr = "";
        } else if (inputStr.equals("null")) {
            inputStr = "";
        }
        return inputStr;
    }

    public static String removeEmptyStr(String inputStr) {
        if (inputStr != null && (inputStr == "" || inputStr.equals("null"))) {
            inputStr = null;
        }
        return inputStr;
    }

    public static String removeStringNull(String inputStr) {
        if (inputStr == null || inputStr.equalsIgnoreCase("null")) {
            inputStr = null;
        }
        return inputStr;
    }

    public static String removeNullAndReturnString(Object a) {
        if (a == null) {
            return "";
        }
        if (a == "null") {
            return "";
        }
        return String.valueOf(a);
    }

    public static Integer removeNullAndReturnInteger(Object a) {
        if (a == null) {
            return 0;
        }
        if (a == "null") {
            return 0;
        }
        if (a.equals("")) {
            return 0;
        }
        return Integer.valueOf(String.valueOf(a));
    }

    public static Long removeNullAndReturnLong(Object a) {
        if (a == null) {
            return 0L;
        }
        if (a == "null") {
            return 0L;
        }
        if (a.equals("")) {
            return 0L;
        }
        return Long.valueOf(String.valueOf(a));
    }

}
