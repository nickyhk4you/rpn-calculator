package com.airwallex.mode;

/**
 * The OriginalUndo mode is the {@link com.airwallex.operator.NumberToken} is not calculated, just the user's original input.
 * In case undo command is fired, it will clear the this NumberToken
 *
 * The CalculatedUndo mode is the {@link com.airwallex.operator.NumberToken} is evaluated through the {@link com.airwallex.operator.Operator},
 * it will revered back to the original argument incase of undo command
 *
 */
public enum UndoMode {
    OriginalUndoMode, CalculatedUndoMode
}
