package tdd;

import java.util.Arrays;

public class HighestNumberFinder {
    public int findHighestNumber(int[] input) {
        Arrays.sort(input);
        return input[input.length - 1];
    }
}
