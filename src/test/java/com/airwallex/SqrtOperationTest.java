package com.airwallex;

import com.airwallex.operator.RPNProcessor;
import org.junit.Test;

public class SqrtOperationTest {


    @Test
    public  void sqrtOperation() {
        String plusInput = "2 sqrt";
        RPNProcessor processor = new RPNProcessor(plusInput);
        try {
            processor.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
