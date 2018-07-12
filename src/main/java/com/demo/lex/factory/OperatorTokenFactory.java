package com.demo.lex.factory;

import com.demo.lex.LexicalAnalyzer;
import com.demo.lex.Token;
import com.demo.lex.TokenMatcher;
import com.demo.operator.Operator;

/**
 * operator token factory for  + - * / sqrt clear undo command
 */
public class OperatorTokenFactory extends BaseTokenFactory {

    public Token createTokenInstance(TokenMatcher tokenMatcher, String value) {

        Token tokenInstance = this.getTokenInstance(tokenMatcher, value);
        Operator operator = (Operator) tokenInstance;
        operator.setNumberStack(LexicalAnalyzer.getNumberTokenStack());
        this.getOperatorLinkedList().add(operator);

        return operator;
    }
}
