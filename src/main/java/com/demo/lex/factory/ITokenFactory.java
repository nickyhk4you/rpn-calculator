package com.demo.lex.factory;

import com.demo.lex.Token;
import com.demo.lex.TokenMatcher;
import com.demo.operator.Operator;

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
