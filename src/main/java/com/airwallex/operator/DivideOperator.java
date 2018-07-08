package com.airwallex.operator;


import com.airwallex.lex.TokenMatcher;

import java.util.List;

/**
 *
 */
public class DivideOperator extends Operator {
    public DivideOperator(String value) {
        super("divide_operator", value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("DivideOperator", "\\/");
    }

    public Double executeInternal(List<NumberToken> numberTokenList) {
        if(numberTokenList.get(1).getValue() == 0){
            return Double.NaN;
        }
        return numberTokenList.get(1).getValue() / numberTokenList.get(0).getValue();
    }

}