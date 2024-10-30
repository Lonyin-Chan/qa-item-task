package org.lbg.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{
    @Test
    void getTotalPrice()
    {
        // arrange
        Item cut = new Item("Banana", 6, 0.19);
        double expectedResult = 1.14;

        // act
        double actualResult = cut.getTotalPrice();

        // assert
        assertEquals(expectedResult, actualResult, 2);
    }
}