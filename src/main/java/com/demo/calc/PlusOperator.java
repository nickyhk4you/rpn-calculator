package com.demo.calc;

import java.lang.Number;

class PlusOperator extends Operator {
  public PlusOperator(String value) {
    super("plus_operator", value);
  }
  
  static TokenMatcher getMatcher() {
    return new TokenMatcher("PlusOperator", "\\+");
  }

  public int priority() {
    return 2;
  }
  
  public String associativity() {
    return "both";
  }
  
  public java.lang.Number execute(java.lang.Number arg[]) {
//    return new Number(arg[0].getValue() + arg[1].getValue());
      return null;
  }
}