package com.airwallex.lex.factory;

import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.operator.Operator;

import java.util.Queue;

/**
 * token factory interface to create the number token or operator token
 */
public interface ITokenFactory {

    /**
     * Create the token instances
     * @param tokenMatcher
     * @param value
     * @return the token created
     */
    public Token createTokenInstance(TokenMatcher tokenMatcher, String value);

    /**
     * set the operator linked list
     * @param operatorLinkedList
     */
    public void setOperatorLinkedList(Queue<Operator> operatorLinkedList);
}
