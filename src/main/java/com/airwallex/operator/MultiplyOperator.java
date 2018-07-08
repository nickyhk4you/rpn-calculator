package com.airwallex.operator;


import com.airwallex.lex.TokenMatcher;

import java.util.List;

/**
 *
 */
public class MultiplyOperator extends Operator {
    public MultiplyOperator(String value) {
        super("multiply", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("MultiplyOperator", "\\*");
    }

    public Double executeInternal(List<NumberToken> numberTokenList) {
        return numberTokenList.get(1).getValue() * numberTokenList.get(0).getValue();
    }

}