package tdd;

import java.util.Arrays;

public class HighestNumberFinder {
    public int findHighestNumber(int[] input) {
//        Arrays.sort(input);
//        return input[input.length - 1];

        int highestSoFar = input[0];

        if (input.length > 1 && input[1] > highestSoFar)
            highestSoFar = input[1];

        return highestSoFar;
    }
}
