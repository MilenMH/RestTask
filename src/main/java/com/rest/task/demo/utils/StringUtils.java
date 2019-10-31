package com.rest.task.demo.utils;

/**
 * Created by Milen on 31.10.2019 г..
 */
public class StringUtils {

    public static String Shrink(String str, int length){
        if (str == null){
            return str;
        }
        if (str.length() < length) {
            return str;
        }
        return str.substring(str.length() - length);
    }
}
