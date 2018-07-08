package com.airwallex.lex.factory;

import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.operator.Operator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Base token factory for generate the token class through reflection
 */
public abstract class BaseTokenFactory implements ITokenFactory {

    private Class[] classArray;
    private Queue<Operator> operatorLinkedList = new LinkedList<Operator>();

    private Class[] getClassArray() {
        if (this.classArray == null) {
            this.classArray = new Class[1];
            classArray[0] = String.class;
        }
        return classArray;
    }

    protected Token getTokenInstance(TokenMatcher tokenMatcher, String value) {
        Token tokenClass = null;

        String path = "com.airwallex.operator." + tokenMatcher.getClassName();
        try {
            tokenClass = (Token) Class.forName(path).getConstructor(getClassArray()).newInstance(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenClass;
    }

    public Queue<Operator> getOperatorLinkedList() {
        return operatorLinkedList;
    }

    public void setOperatorLinkedList(Queue<Operator> operatorLinkedList) {
        this.operatorLinkedList = operatorLinkedList;
    }

}
