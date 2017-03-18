package com.example.printdigit;

import com.example.printdigit.service.PrintInstructionProvider;
import com.example.printdigit.service.PrintOutputProvider;
import com.example.printdigit.service.impl.ConsolePrintOutputProvider;
import com.example.printdigit.service.impl.SevenSegmentPrintInstructionProvider;
import com.example.printdigit.util.NumberUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Anand on 18-03-2017.
 */
public class PrintDigitMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            List<Integer> digits = NumberUtils.toDigits(number);
            PrintOutputProvider printOutputProvider = new ConsolePrintOutputProvider('#', 8, digits.size() * 3);
            PrintInstructionProvider instructionProvider = new SevenSegmentPrintInstructionProvider();
            IntStream.range(0, digits.size())
                    .mapToObj(i -> i)
                    .flatMap(i -> instructionProvider.printInstructions(digits.get(i), i))
                    .sorted()
                    .forEach(printOutputProvider::print);
        }
    }
}
