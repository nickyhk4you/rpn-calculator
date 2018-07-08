package com.airwallex.lex;


import com.airwallex.lex.factory.TokenFactory;
import com.airwallex.operator.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;

/**
 * Main lexical analyzer to parse the input from the user.
 */
public class LexicalAnalyzer {

    private String expression;
    private List<TokenMatcher> registeredTokens = new ArrayList<TokenMatcher>();
    private List<Token> tokenObjects = new ArrayList<Token>();

    private static Stack<NumberToken> numberTokenStack = new Stack<NumberToken>();
    private Queue<Operator> operatorLinkedList = new LinkedList<Operator>();

    public LexicalAnalyzer(String exp) throws Exception {
        expression = exp;
        if (expression == null || expression.equalsIgnoreCase("")) {
            throw new Exception("Expression to tokenize is empty");
        }
        registeredTokens.add(NumberToken.getMatcher());
        registeredTokens.add(PlusOperator.getMatcher());
        registeredTokens.add(MinusOperator.getMatcher());
        registeredTokens.add(MultiplyOperator.getMatcher());
        registeredTokens.add(DivideOperator.getMatcher());

        registeredTokens.add(UndoOperator.getMatcher());
        registeredTokens.add(ClearOperator.getMatcher());
        registeredTokens.add(SqrtOperator.getMatcher());
    }

    private Token tokenFactory(TokenMatcher tokenMatcher, String value) throws Exception {
        return TokenFactory.createInstance(tokenMatcher, value, operatorLinkedList);
    }


    public List<Token> tokenize() throws Exception {
        boolean isMatch = false;

        while (expression.length() > 0) {
            isMatch = false;
            for (TokenMatcher tokenMatcher : registeredTokens) {
                Matcher matcher = tokenMatcher.getRegexp().matcher(expression);
                if (!isMatch && matcher.find()) {
                    isMatch = true;
                    tokenObjects.add(tokenFactory(tokenMatcher, matcher.group()));
                    expression = expression.substring(matcher.group().length());
                    expression = expression.startsWith(" ") ? expression.substring(1) : expression;
                    break;
                }
            }
            if (!isMatch) {
                throw new Exception("Unrecognized token: '" + expression + "'");
            }
        }
        return tokenObjects;
    }


    public Queue<Operator> getOperatorLinkedList() {
        return operatorLinkedList;
    }


    public static Stack<NumberToken> getNumberTokenStack() {
        return numberTokenStack;
    }

    public static void setNumberTokenStack(Stack<NumberToken> numberTokenStack) {
        LexicalAnalyzer.numberTokenStack = numberTokenStack;
    }
}
