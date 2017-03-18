package com.example.printdigit.service.impl;

import com.example.printdigit.dto.PrintInstruction;
import com.example.printdigit.service.PrintInstructionProvider;

import java.util.stream.Stream;

import static com.example.printdigit.dto.Instruction.*;

/**
 * Created by Anand on 18-03-2017.
 */
public class SevenSegmentPrintInstructionProvider implements PrintInstructionProvider {

    @Override
    public Stream<PrintInstruction> printInstructions(int digit, int columnOrder) {
        int column = (columnOrder * 3) + 1;
        int rowOrder = -1;
        Stream.Builder<PrintInstruction> builder = Stream.builder();
        switch (digit) {
            case 0:
                printLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 1:
                printNoLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                break;
            case 2:
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printLeftColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 3:
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 4:
                printNoLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                break;
            case 5:
                printLine(++rowOrder, builder, column);
                rowOrder = printLeftColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 6:
                printLine(++rowOrder, builder, column);
                rowOrder = printLeftColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 7:
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printNoLine(++rowOrder, builder, column);
                break;
            case 8:
                printLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
            case 9:
                printLine(++rowOrder, builder, column);
                rowOrder = printColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                rowOrder = printRightColumn(rowOrder, builder, column);
                printLine(++rowOrder, builder, column);
                break;
        }
        return builder.build();
    }

    private void printNoLine(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column));
        builder.add(new PrintInstruction(LINE_SPACE, rowOrder, column + 1));
        builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column + 2));
    }

    private int printColumn(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        for (int i = 0; i < 3; i++) {
            rowOrder++;
            printColumnSegment(rowOrder, builder, column);
        }
        return rowOrder;
    }

    private int printLeftColumn(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        for (int i = 0; i < 3; i++) {
            rowOrder++;
            builder.add(new PrintInstruction(DOT, rowOrder, column));
            builder.add(new PrintInstruction(LINE_SPACE, rowOrder, column + 1));
            builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column + 2));
        }
        return rowOrder;
    }

    private int printRightColumn(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        for (int i = 0; i < 3; i++) {
            rowOrder++;
            builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column));
            builder.add(new PrintInstruction(LINE_SPACE, rowOrder, column + 1));
            builder.add(new PrintInstruction(DOT, rowOrder, column + 2));
        }
        return rowOrder;
    }

    private void printColumnSegment(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        builder.add(new PrintInstruction(DOT, rowOrder, column));
        builder.add(new PrintInstruction(LINE_SPACE, rowOrder, column + 1));
        builder.add(new PrintInstruction(DOT, rowOrder, column + 2));
    }

    private void printLine(int rowOrder, Stream.Builder<PrintInstruction> builder, int column) {
        builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column));
        builder.add(new PrintInstruction(LINE, rowOrder, column + 1));
        builder.add(new PrintInstruction(SINGLE_SPACE, rowOrder, column + 2));
    }
}
