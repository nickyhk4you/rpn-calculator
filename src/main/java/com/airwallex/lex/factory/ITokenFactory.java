package com.airwallex.lex.factory;

import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.operator.Operator;

import java.util.Queue;

/**
 * token factory interface to create the number token or operator token
 */
public interface ITokenFactory {

    public Token createTokenInstance(TokenMatcher tokenMatcher, String value);

    public void setOperatorLinkedList(Queue<Operator> operatorLinkedList);
}
