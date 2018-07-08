package com.demo.calc;

import java.lang.Number;

class DivideOperator extends Operator {
  public DivideOperator(String value) {
    super("divide_operator", value);
  }
  
  static TokenMatcher getMatcher() {
    return new TokenMatcher("DivideOperator", "\\/");
  }

  public int priority() {
    return 3;
  }
  
  public String associativity() {
    return "left";
  }
  
  public java.lang.Number execute(java.lang.Number arg[]) {
//    return new Number(arg[0].getValue() / arg[1].getValue());
//    return new Number();
      return null;
  }
}