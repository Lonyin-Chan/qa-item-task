package tdd;

import java.util.Arrays;

public class HighestNumberFinder {
    public int findHighestNumber(int[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int max = input[0];
        for (int number : input) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
