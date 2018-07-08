package com.airwallex.operator;


import com.airwallex.lex.Token;
import com.airwallex.lex.TokenMatcher;
import com.airwallex.mode.ClearMode;
import com.airwallex.mode.UndoMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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