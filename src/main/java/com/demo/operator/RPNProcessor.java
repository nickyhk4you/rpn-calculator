package com.demo.operator;

import com.demo.lex.LexicalAnalyzer;
import com.demo.mode.ClearMode;
import com.demo.mode.UndoMode;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 */
public class RPNProcessor {
    private String inputString;
    private LexicalAnalyzer lexicalAnalyzer;
    private static Logger logger = Logger.getLogger(RPNProcessor.class.getClass());

    public RPNProcessor(final String inputString) {
        this.inputString = inputString;
    }


    public void execute() throws Exception {
        logger.info("input >> " + inputString);
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
            BigDecimal result = operator.execute(numberTokenList);
            if (result != null) {
                NumberToken resultNumberToken = new NumberToken(result);
                resultNumberToken.setUndoMode(UndoMode.CalculatedUndoMode);
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
