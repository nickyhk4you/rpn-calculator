package com.airwallex.lex;


import com.airwallex.mode.ClearMode;
import com.airwallex.mode.UndoMode;
import com.airwallex.operator.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;

/**
 * Main lexical analyzer to parse the input from the user.
 */
public class LexicalAnalyzer {

    private static Logger logger = Logger.getLogger(LexicalAnalyzer.class.getClass());
    private String expression;
    private List<TokenMatcher> registeredTokens = new ArrayList<TokenMatcher>();
    private Class[] classArray;
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

        Token tokenClass = null;
        try {
            String path = "com.airwallex.operator." + tokenMatcher.getClassName();
            tokenClass = (Token) Class.forName(path).getConstructor(getClassArray()).newInstance(value);
            if (tokenClass instanceof Operator) {
                Operator operator = (Operator) tokenClass;
                operator.setNumberStack(numberTokenStack);
                this.operatorLinkedList.add(operator);
            } else if (tokenClass instanceof NumberToken) {
                NumberToken numberToken = (NumberToken) tokenClass;
                numberToken.setClearMode(ClearMode.LexicalMode);
                numberToken.setUndoMode(UndoMode.LexicalMode);
                this.numberTokenStack.push(numberToken);
            }
        } catch (Exception e) {
            throw new Exception("Lexer: " + e.getMessage());
        }

        return tokenClass;
    }


    public List<Token> tokenize() throws Exception {
        boolean isMatch = false;

        while (expression.length() > 0) {
            isMatch = false;
            for (TokenMatcher tr : registeredTokens) {
                Matcher m = tr.getRegexp().matcher(expression);
                if (!isMatch && m.find()) {
                    isMatch = true;
                    tokenObjects.add(tokenFactory(tr, m.group()));
                    expression = expression.substring(m.group().length());
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


    private Class[] getClassArray() {
        if (this.classArray == null) {
            this.classArray = new Class[1];
            classArray[0] = String.class;
        }
        return classArray;
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
