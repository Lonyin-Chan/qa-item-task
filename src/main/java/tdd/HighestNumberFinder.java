package tdd;

import java.util.Arrays;

public class HighestNumberFinder {
    public int findHighestNumber(int[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        Arrays.sort(input);
        return input[input.length - 1];
    }
}
