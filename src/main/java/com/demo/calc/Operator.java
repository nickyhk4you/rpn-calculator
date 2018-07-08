package com.demo.calc;

import java.lang.Number;

abstract class Operator extends Token {
  public Operator(String type, String value) {
    super(type, value);
  }
  
  public int numOfArgs() {
    return 2;
  }
  
  abstract public int priority();
  abstract public String associativity();
  abstract public java.lang.Number execute(Number arg[]);
}