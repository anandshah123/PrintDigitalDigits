package com.example.printdigit.service.impl;

import com.example.printdigit.dto.PrintInstruction;
import com.example.printdigit.service.PrintOutputProvider;

/**
 * Created by Anand on 18-03-2017.
 */
public class ConsolePrintOutputProvider implements PrintOutputProvider {

    private char symbol = '*';

    private int lineLength = 10;

    private final int newLineAfterInstructions;

    private int printHead = 0;

    public ConsolePrintOutputProvider(char symbol, int lineLength, int newLineAfterInstructions) {
        this.symbol = symbol;
        this.lineLength = lineLength;
        this.newLineAfterInstructions = newLineAfterInstructions;
    }

    public ConsolePrintOutputProvider(int newLineAfterInstructions) {
        this.newLineAfterInstructions = newLineAfterInstructions;
    }

    @Override
    public synchronized void print(PrintInstruction printInstruction) {
        if (printHead % newLineAfterInstructions == 0) System.out.println();
        // Move print head till end of line
        printHead++;
        switch (printInstruction.getInstruction()) {
            case DOT:
                printSymbolTimes(symbol, 1);
                break;
            case LINE:
                printSymbolTimes(symbol, lineLength);
                break;
            case LINE_SPACE:
                printSymbolTimes(' ', lineLength);
                break;
            case SINGLE_SPACE:
                printSymbolTimes(' ', 1);
                break;
        }
    }

    @Override
    public synchronized void resetHead() {
        printHead = 0;
    }

    private void printSymbolTimes(char symbol, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(symbol);
        }
    }
}
