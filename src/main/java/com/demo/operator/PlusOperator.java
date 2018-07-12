package com.demo.operator;


import com.demo.lex.TokenMatcher;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class PlusOperator extends Operator {
    public PlusOperator(String value) {
        super("plus", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("PlusOperator", "\\+");
    }

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        return numberTokenList.get(1).getValue().add(numberTokenList.get(0).getValue());
    }

}