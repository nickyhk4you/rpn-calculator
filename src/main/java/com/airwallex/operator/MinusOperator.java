package com.airwallex.operator;


import com.airwallex.lex.TokenMatcher;

import java.util.List;

public class MinusOperator extends Operator {
    public MinusOperator(String value) {
        super("minus", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("MinusOperator", "\\-");
    }

    public Double executeInternal(List<NumberToken> numberTokenList) {
        return numberTokenList.get(1).getValue() - numberTokenList.get(0).getValue();
    }

}