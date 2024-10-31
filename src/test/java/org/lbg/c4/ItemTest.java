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

    @Test
    public void toString_check_correct_format() {
        Item cut = new Item(1, 32, 4, 0.2);
        String expectedResult = "Item 1 total cost: £153.60";

        String actualResult = cut.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTotalPrice_negative_quantity() {
        Item cut = new Item(1, 32, -4, 0.2);
        double expectedResult = 153.6;

        double actualResult = cut.getTotalPrice();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTotalPrice_negative_cost() {
        Item cut = new Item(1, -32, 4, 0.2);
        double expectedResult = 153.6;

        double actualResult = cut.getTotalPrice();

        assertEquals(expectedResult, actualResult);
    }
}
