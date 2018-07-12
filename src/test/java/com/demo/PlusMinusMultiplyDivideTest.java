package com.demo;

import com.demo.lex.LexicalAnalyzer;
import com.demo.operator.RPNProcessor;
import org.junit.Test;

public class PlusMinusMultiplyDivideTest {

    @Test
    public  void plusOperation() {
        String plusInput = "5 2 +";
        RPNProcessor processor = new RPNProcessor(plusInput);
        try {
            processor.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void minusOperation() {
        String plusInput = "5 2 -";
        RPNProcessor processor = new RPNProcessor(plusInput);
        try {
            processor.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void multiplyOperation() {
        String plusInput = "5 2 *";
        RPNProcessor processor = new RPNProcessor(plusInput);
        try {
            processor.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void divideOperation() {
        String plusInput = "5 2 /";
        RPNProcessor processor = new RPNProcessor(plusInput);
        try {
            processor.execute();
            LexicalAnalyzer.getNumberTokenStack().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
