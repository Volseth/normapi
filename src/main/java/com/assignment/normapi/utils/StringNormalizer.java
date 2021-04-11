package com.assignment.normapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNormalizer {

    public static String normalizeString(String element, Pattern pattern){
        Matcher matcher = pattern.matcher(element);
        return matcher.replaceAll("");
    }
}
