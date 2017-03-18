package com.example.printdigit.service;

import com.example.printdigit.dto.PrintInstruction;

import java.util.stream.Stream;

/**
 * Created by Anand on 18-03-2017.
 */
public interface PrintInstructionProvider {

    Stream<PrintInstruction> printInstructions(int digit, int column);
}
