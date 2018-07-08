package com.airwallex.lex.factory;


import com.airwallex.lex.LexicalAnalyzer;
import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.mode.ClearMode;
import com.airwallex.mode.UndoMode;
import com.airwallex.operator.NumberToken;

/**
 * Number Token Factory to create the Number Token instance
 */
public class NumberTokenFactory extends BaseTokenFactory{


    public Token createTokenInstance(TokenMatcher tokenMatcher, String value) {
        Token tokenInstance = this.getTokenInstance(tokenMatcher, value);
        NumberToken numberToken = (NumberToken) tokenInstance;
        numberToken.setClearMode(ClearMode.LexicalMode);
        numberToken.setUndoMode(UndoMode.LexicalMode);

        LexicalAnalyzer.getNumberTokenStack().push(numberToken);
        return null;
    }
}
