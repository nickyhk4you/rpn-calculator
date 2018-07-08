package com.airwallex;

import com.airwallex.lex.LexicalAnalyzer;
import com.airwallex.operator.RPNProcessor;
import org.junit.Test;

public class ComplexRPNCalculatorTest {

    @Test
    public void complexClearOperationTest() {
        String input = "2 sqrt";
        RPNProcessor processor = new RPNProcessor(input);
        try {
            processor.execute();

            String input2 = "clear 9 sqrt";
            RPNProcessor processor2 = new RPNProcessor(input2);
            processor2.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void complexUndoOperationTest() {
        String input = "1 2 3 4 5";
        RPNProcessor processor = new RPNProcessor(input);
        try {
            processor.execute();

            String input2 = "*";
            RPNProcessor processor2 = new RPNProcessor(input2);
            processor2.execute();
            String input3 = "clear 3 4 -";
            RPNProcessor processor3 = new RPNProcessor(input3);
            processor3.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
