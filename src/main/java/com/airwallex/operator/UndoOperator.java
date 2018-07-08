package com.airwallex.operator;

import com.airwallex.lex.TokenMatcher;
import com.airwallex.mode.UndoMode;

import java.math.BigDecimal;
import java.util.List;

public class UndoOperator extends Operator {

    public UndoOperator(String value) {
        super("undo", value);
    }

    public UndoOperator(String type, String value) {
        super(type, value);
    }

    public static TokenMatcher getMatcher() {
        return new TokenMatcher("UndoOperator", "undo");
    }

    public String associativity() {
        return null;
    }

    public BigDecimal executeInternal(List<NumberToken> numberTokenList) {
        if (this.getNumberStack() != null) {
            if (UndoMode.OriginalUndoMode.equals(numberTokenList.get(0).getUndoMode())) {
                //simply remove it, as we already pop up the fields,nothing need to do here
            } else if (UndoMode.CalculatedUndoMode.equals(numberTokenList.get(0).getUndoMode())) {
                List<NumberToken> undoHistory = numberTokenList.get(0).getUndoHistory();
                for (NumberToken numberToken : undoHistory) {
                    this.getNumberStack().push(numberToken);
                }
            }
        }
        return null;
    }

    @Override
    public int getOperatorAcceptableArgs() {
        return 1;
    }
}
