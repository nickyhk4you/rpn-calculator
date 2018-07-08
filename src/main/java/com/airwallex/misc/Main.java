package com.airwallex.misc;

import com.airwallex.operator.RPNProcessor;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {

    private RPNProcessor processor;
    private static Logger log = Logger.getLogger(Main.class.getClass());


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
