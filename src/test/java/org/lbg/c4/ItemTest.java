package org.lbg.c4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void getTotalPrice_correct_total_calculated() {
        Item cut1 = new Item(1, 32, 4, 0.2);
        Item cut2 = new Item(1, 12, 42, 0.21);
        double expectedResult1 = 153.6;
        double expectedResult2 = 609.84;

        double actualResult1 = cut1.getTotalPrice();
        double actualResult2 = cut2.getTotalPrice();

        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }
}
