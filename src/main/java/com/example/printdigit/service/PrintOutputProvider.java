package com.example.printdigit.service;

import com.example.printdigit.dto.PrintInstruction;

/**
 * Created by Anand on 18-03-2017.
 */
public interface PrintOutputProvider {

    void print(PrintInstruction instruction);

    void resetHead();
}
