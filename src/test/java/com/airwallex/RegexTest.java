package com.airwallex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public  void numberReg() {
        String regexp = "^[\\d.]+";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("2 3 +");
        Assert.assertTrue(matcher.find());
    }
    @Test
    public  void operatonMultiplyReg() {
        String regexp = "^\\*";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("* 3 +");
        Assert.assertTrue(matcher.find());
    }
    @Test
    public  void operatonlusReg() {
        String regexp = "^\\+";
        Pattern pattern = Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("+ 3 2");
        Assert.assertTrue(matcher.find());
    }
}
