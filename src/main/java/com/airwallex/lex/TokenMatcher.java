package com.airwallex.lex;

import java.util.regex.Pattern;

public class TokenMatcher {
  private String regexp;
  private String className;
  
  public TokenMatcher(String className, String regexp) {
    this.className = className;
    this.regexp = regexp;
  }
  
  public Pattern getRegexp() {
    return Pattern.compile("^(" + regexp + ")", Pattern.CASE_INSENSITIVE);
  }
  
  public String getClassName() {
    return className;
  }
}