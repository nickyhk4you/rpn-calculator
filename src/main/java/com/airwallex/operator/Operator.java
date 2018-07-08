package com.airwallex.operator;

import com.airwallex.lex.Token;

import java.util.List;
import java.util.Stack;

public abstract class Operator extends Token {

    public Operator(String type, String value) {
        super(type, value);
    }

    public Double execute(List<NumberToken> numberTokenList) {
        return this.executeInternal(numberTokenList);
    }

    public abstract Double executeInternal(List<NumberToken> numberTokenList);

    private Stack<NumberToken> numberStack;

    public Stack<NumberToken> getNumberStack() {
        return numberStack;
    }

    public void setNumberStack(Stack<NumberToken> numberStack) {
        this.numberStack = numberStack;
    }

    public int getOperatorAcceptableArgs() {
        return 2;
    }
}
