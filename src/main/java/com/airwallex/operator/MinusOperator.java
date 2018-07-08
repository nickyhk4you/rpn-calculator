package com.airwallex.operator;


import com.airwallex.lex.TokenMatcher;

import java.math.BigDecimal;
import java.util.List;

public class MinusOperator extends Operator {
    public MinusOperator(String value) {
        super("minus", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("MinusOperator", "\\-");
    }

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        return numberTokenList.get(1).getValue().subtract(numberTokenList.get(0).getValue());
    }

}