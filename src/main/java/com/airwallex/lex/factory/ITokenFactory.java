package com.airwallex.lex.factory;

import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;

public interface ITokenFactory {

    public Token createTokenInstance(TokenMatcher tokenMatcher, String value);
}
