package com.airwallex.misc;

import com.airwallex.operator.RPNProcessor;

import java.util.Scanner;

public class Main {

    private RPNProcessor processor;

    public static void main(String[] args) throws Exception {
        String inputLine = null;
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String nextLine = input.nextLine();
            RPNProcessor processor = new RPNProcessor(nextLine);
            processor.execute();
        }
        input.nextLine();
        input.close();

    }


}
