package com.demo.calc;

import java.lang.Number;

class MultiplyOperator extends Operator {
  public MultiplyOperator(String value) {
    super("multiply_operator", value);
  }
  
  static TokenMatcher getMatcher() {
    return new TokenMatcher("MultiplyOperator", "\\*");
  }

  public int priority() {
    return 3;
  }
  
  public String associativity() {
    return "both";
  }
  
  public java.lang.Number execute(java.lang.Number arg[]) {
//    return new Number(arg[0].getValue() * arg[1].getValue());
    return null;
  }
}