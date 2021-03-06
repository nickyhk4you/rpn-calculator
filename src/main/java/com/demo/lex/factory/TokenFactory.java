package com.demo.lex.factory;

import com.demo.lex.Token;
import com.demo.lex.TokenMatcher;
import com.demo.operator.Operator;

import java.util.Queue;

/**
 * Entry point of token factory, it uses the factory design pattern.
 */
public class TokenFactory {

    public static Token createInstance(TokenMatcher tokenMatcher, String value, Queue<Operator> operatorLinkedList ) {
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
