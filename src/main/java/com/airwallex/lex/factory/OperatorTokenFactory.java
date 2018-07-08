package com.airwallex.lex.factory;

import com.airwallex.lex.LexicalAnalyzer;
import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.operator.Operator;

/**
 *
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
