package com.airwallex.operator;


import com.airwallex.lex.TokenMatcher;

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

    public Double executeInternal(List<NumberToken> numberTokenList) {
        return  numberTokenList.get(1).getValue() + numberTokenList.get(0).getValue();
    }

}