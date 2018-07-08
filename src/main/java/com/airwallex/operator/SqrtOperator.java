package com.airwallex.operator;

import com.airwallex.lex.TokenMatcher;

import java.util.List;

public class SqrtOperator extends Operator{
    public SqrtOperator(String value) {
        super("Sqrt", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("SqrtOperator", "sqrt");
    }

    public Double executeInternal(List<NumberToken> numberTokenList) {
        return Math.sqrt(numberTokenList.get(0).getValue());
    }
    @Override
    public int getOperatorAcceptableArgs() {
        return 1;
    }}
