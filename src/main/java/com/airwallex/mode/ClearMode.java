package com.airwallex.mode;

/**
 * The clear mode for the numberToken.
 *
 * For one specific NumberToken, it explicitly set the OriginalUndoMode during the Lexical analysis phase for new NumberToken from user's input.
 * It means this NumberToken for OriginalUndoMode will not be cleared by Clear command.
 *
 * user's input: 2 sqrt
 *               stack: 1.4142135623  <- this NumberToken in Stack is NonLexicalMode, it means this NumberToken could be cleared by Clear command
 *
 * user's input then: clear 9 sqrt  <- Here the NumberToken 9 is in OriginalUndoMode, the NumberToken will not get cleard by clear command during lexical analysis
 *
 *
 */
public enum ClearMode {
    LexicalMode, NonLexicalMode
}
