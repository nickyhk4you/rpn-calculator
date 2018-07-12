package com.demo.operator;


import com.demo.lex.TokenMatcher;

import java.math.BigDecimal;
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

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        if(numberTokenList.get(1).getValue().doubleValue() == 0){
            return new BigDecimal(Double.NaN);
        }
        return numberTokenList.get(1).getValue().divide(numberTokenList.get(0).getValue());
    }

}