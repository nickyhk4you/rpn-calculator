package com.demo.lex.factory;


import com.demo.lex.LexicalAnalyzer;
import com.demo.lex.Token;
import com.demo.lex.TokenMatcher;
import com.demo.mode.ClearMode;
import com.demo.mode.UndoMode;
import com.demo.operator.NumberToken;

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
