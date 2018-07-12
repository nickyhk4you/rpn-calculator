package com.demo.lex;

public abstract class Token {
    protected Object value;
    private String type;

    public Token() {
    }

    public Token(String type, Object value) {
        this.value = value;
        this.type = type;
    }


//    public void setValue(Object value) {
//        this.value = value;
//    }

    public Object getValue() {
        return value;
    }


}