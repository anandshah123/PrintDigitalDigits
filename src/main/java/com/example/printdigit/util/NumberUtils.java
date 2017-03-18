package com.example.printdigit.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand on 18-03-2017.
 */
public class NumberUtils {

    public static List<Integer> toDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            String str = String.valueOf(number);
            digits.add(new Integer("" + str.charAt(i)));
        }
        return digits;
    }
}
