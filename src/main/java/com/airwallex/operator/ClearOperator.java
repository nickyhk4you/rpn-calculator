package com.airwallex.operator;

import com.airwallex.lex.LexicalAnalyzer;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.mode.ClearMode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

/**
 * Clear Operator
 */
public class ClearOperator extends Operator {
    public static TokenMatcher getMatcher() {
        return new TokenMatcher("ClearOperator", "clear");
    }

    public ClearOperator(String value) {
        super("clear", value);
    }

    public ClearOperator(String type, String value) {
        super(type, value);
    }

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {

        Stack<NumberToken> reversedNumberToken = new Stack<NumberToken>();

        while(!LexicalAnalyzer.getNumberTokenStack().empty()){
            NumberToken numberToken = LexicalAnalyzer.getNumberTokenStack().pop();
            if(numberToken.getClearMode().equals(ClearMode.LexicalMode)){
                reversedNumberToken.push(numberToken);
            }
        }

        LexicalAnalyzer.getNumberTokenStack().clear();

        while(!reversedNumberToken.empty()){
            NumberToken numberToken = reversedNumberToken.pop();
            LexicalAnalyzer.getNumberTokenStack().push(numberToken);
        }

        return null;
    }
    @Override
    public int getOperatorAcceptableArgs() {
        return 0;
    }
}
