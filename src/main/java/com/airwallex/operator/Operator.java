package com.airwallex.operator;

import com.airwallex.lex.Token;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

/**
 * Abstract class for all the operator for lexicial analysis
 */
public abstract class Operator extends Token {

    private static Logger logger = Logger.getLogger(Operator.class.getClass());

    public Operator(String type, String value) {
        super(type, value);
    }

    public BigDecimal execute(List<NumberToken> numberTokenList) {
        if(logger.isDebugEnabled()){
            logger.debug(numberTokenList.toString());
        }
        return this.executeInternal(numberTokenList);
    }

    public abstract BigDecimal executeInternal(List<NumberToken> numberTokenList);

    private Stack<NumberToken> numberStack;

    public Stack<NumberToken> getNumberStack() {
        return numberStack;
    }

    public void setNumberStack(Stack<NumberToken> numberStack) {
        this.numberStack = numberStack;
    }

    /**
     * The default accepetable argument for the operator, normally the default argument is 2
     * @return
     */
    public int getOperatorAcceptableArgs() {
        return 2;
    }
}
