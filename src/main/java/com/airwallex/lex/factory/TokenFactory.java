package com.airwallex.lex.factory;

import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.operator.Operator;

import java.util.Queue;

public class TokenFactory {

    public static Token createInstance(TokenMatcher tokenMatcher, String value,Queue<Operator> operatorLinkedList ) {
        ITokenFactory factory = null;
        if ("NumberToken".equalsIgnoreCase(tokenMatcher.getClassName())) {
            factory = new NumberTokenFactory();
        } else {
            factory = new OperatorTokenFactory();
            factory.setOperatorLinkedList(operatorLinkedList);
        }
        return factory.createTokenInstance(tokenMatcher, value);
    }
}
