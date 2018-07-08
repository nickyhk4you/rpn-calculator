package com.airwallex.operator;

import com.airwallex.lex.Token;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public abstract class Operator extends Token {

    public Operator(String type, String value) {
        super(type, value);
    }

    public BigDecimal execute(List<NumberToken> numberTokenList) {
        return this.executeInternal(numberTokenList);
    }

    public abstract BigDecimal executeInternal(List<NumberToken> numberTokenList);

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
