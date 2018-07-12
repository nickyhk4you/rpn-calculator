package com.demo.operator;

import com.demo.lex.LexicalAnalyzer;
import com.demo.lex.TokenMatcher;
import com.demo.mode.ClearMode;

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

    /**
     * The business logic for clear command. In case of the Clear command is fired, the {@link ClearMode} LexicalMode will not be cleared.
     * It will dummped into a temp Stack, and then push it back into the original result stack
     *
     * @param numberTokenList
     * @return null value
     */
    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {

        Stack<NumberToken> reversedNumberToken = new Stack<NumberToken>();

        while(!LexicalAnalyzer.getNumberTokenStack().empty()){
            NumberToken numberToken = LexicalAnalyzer.getNumberTokenStack().pop();
            if(numberToken.getClearMode().equals(ClearMode.LexicalMode)){
                reversedNumberToken.push(numberToken);
            }
        }
        //only the non lexical mode number token will get cleared inside the stack
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
