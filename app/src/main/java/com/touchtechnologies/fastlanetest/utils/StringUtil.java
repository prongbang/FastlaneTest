package com.touchtechnologies.fastlanetest.utils;

/**
 * Created by mdev on 1/9/2018 AD.
 */

public class StringUtil {

    public static String revert(String msg) {
        if (msg == null) return null;

        return new StringBuilder(msg).reverse().toString();
    }

}
