package com.demo.mode;

import com.demo.operator.NumberToken;
import com.demo.operator.Operator;

/**
 * The OriginalUndo mode is the {@link NumberToken} is not calculated, just the user's original input.
 * In case undo command is fired, it will clear the this NumberToken
 *
 * The CalculatedUndo mode is the {@link NumberToken} is evaluated through the {@link Operator},
 * it will revered back to the original argument incase of undo command
 *
 */
public enum UndoMode {
    OriginalUndoMode, CalculatedUndoMode
}
