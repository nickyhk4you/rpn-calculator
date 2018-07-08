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


    /**
     * create the token instance and set the clear mode & undo mode.
     * Please note the clear mode & undo mode for Number token for non lexical mode could be cleard
     * @param tokenMatcher
     * @param value
     * @return
     */
    public Token createTokenInstance(TokenMatcher tokenMatcher, String value) {
        Token tokenInstance = this.getTokenInstance(tokenMatcher, value);
        NumberToken numberToken = (NumberToken) tokenInstance;
        numberToken.setClearMode(ClearMode.LexicalMode);
        numberToken.setUndoMode(UndoMode.OriginalUndoMode);

        LexicalAnalyzer.getNumberTokenStack().push(numberToken);
        return numberToken;
    }
}
