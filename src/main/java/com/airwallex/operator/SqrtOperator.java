package com.airwallex.operator;

import com.airwallex.lex.TokenMatcher;

import java.math.BigDecimal;
import java.util.List;

public class SqrtOperator extends Operator{
    public SqrtOperator(String value) {
        super("Sqrt", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("SqrtOperator", "sqrt");
    }

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        return new BigDecimal(Math.sqrt(numberTokenList.get(0).getValue().doubleValue()));
    }
    @Override
    public int getOperatorAcceptableArgs() {
        return 1;
    }}
