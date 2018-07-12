package com.demo.operator;


import com.demo.lex.Token;
import com.demo.lex.TokenMatcher;
import com.demo.mode.ClearMode;
import com.demo.mode.UndoMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic number token, it represent the number for the input string
 */
public class NumberToken extends Token {
    public NumberToken(String value) {
        super("number", new BigDecimal(value));
    }

    public NumberToken(BigDecimal value) {
        super("NumberToken", value);
    }

    private ClearMode clearMode;
    private UndoMode undoMode;
    private List<NumberToken> undoHistory = new ArrayList<NumberToken>();

    public BigDecimal getValue() {
        return (BigDecimal) value;
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("NumberToken", "[\\d.]+");
    }

    @Override
    public String toString() {
        return "NumberToken{" +
                "clearMode=" + clearMode +
                ", undoMode=" + undoMode +
                ", value=" + value +
                '}';
    }

    public ClearMode getClearMode() {
        return clearMode;
    }

    public void setClearMode(ClearMode clearMode) {
        this.clearMode = clearMode;
    }

    public UndoMode getUndoMode() {
        return undoMode;
    }

    public void setUndoMode(UndoMode undoMode) {
        this.undoMode = undoMode;
    }

    public List<NumberToken> getUndoHistory() {
        return undoHistory;
    }

    public void setUndoHistory(List<NumberToken> undoHistory) {
        this.undoHistory = undoHistory;
    }
}