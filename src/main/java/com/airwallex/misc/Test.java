package com.airwallex.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        numberReg();
        operatonMultiplyReg();
        operatonlusReg();

    }

    public static void numberReg() {
        String regexp = "^[\\d.]+";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("2 3 +");
        System.out.println(matcher.find());
    }

    public static void operatonMultiplyReg() {
        String regexp = "^\\*";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("* 3 +");
        System.out.println(matcher.find());
    }

    public static void operatonlusReg() {
        String regexp = "^\\+";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("+ 3 2");
        System.out.println(matcher.find());
    }
}
