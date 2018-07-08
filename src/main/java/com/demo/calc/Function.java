package com.demo.calc;

import java.lang.Number;

abstract class Function extends Token {
  public Function(String type, String value) {
	super(type, value);
  }
  
  abstract public java.lang.Number execute(Number arg[]);
  abstract int numOfArgs();
}