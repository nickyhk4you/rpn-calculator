package com.demo.operator;


import com.demo.lex.TokenMatcher;

import java.math.BigDecimal;
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

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        return numberTokenList.get(1).getValue().multiply(numberTokenList.get(0).getValue());
    }

}