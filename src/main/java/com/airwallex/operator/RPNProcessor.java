package com.airwallex.operator;

import com.airwallex.lex.LexicalAnalyzer;
import com.airwallex.mode.ClearMode;
import com.airwallex.mode.UndoMode;

import java.util.*;

/**
 *
 */
public class RPNProcessor {
    private String inputString;
    private LexicalAnalyzer lexicalAnalyzer;

    public RPNProcessor(final String inputString) {
        this.inputString = inputString;
    }


    public void execute() throws Exception {
        System.out.println(">> " + inputString);
        if (this.lexicalAnalyzer == null) {
            this.lexicalAnalyzer = new LexicalAnalyzer(this.inputString);
        }
        lexicalAnalyzer.tokenize();

        Queue<Operator> operatorQueue = lexicalAnalyzer.getOperatorLinkedList();

        while (!operatorQueue.isEmpty()) {
            Operator operator = operatorQueue.remove();

            List<NumberToken> numberTokenList = new ArrayList<NumberToken>();

            for (int i = 0; i < operator.getOperatorAcceptableArgs(); i++) {
                numberTokenList.add(operator.getNumberStack().pop());
            }
            Double result = operator.execute(numberTokenList);
            if (result != null) {
                NumberToken resultNumberToken = new NumberToken(result);
                resultNumberToken.setUndoMode(UndoMode.ResultMode);
                resultNumberToken.setUndoHistory(numberTokenList);
                LexicalAnalyzer.getNumberTokenStack().push(resultNumberToken);
                for (int j = 0; j < LexicalAnalyzer.getNumberTokenStack().size(); j++) {
                    LexicalAnalyzer.getNumberTokenStack().get(j).setClearMode(ClearMode.NonLexicalMode);
                }
            }
        }


        Stack<NumberToken> numberTokenStack = lexicalAnalyzer.getNumberTokenStack();
        System.out.print("Stack: ");
        for (int i = 0; i < numberTokenStack.size(); i++) {
            System.out.print(numberTokenStack.get(i).getValue() + " ");
        }
        System.out.print("\n ");
    }

}
