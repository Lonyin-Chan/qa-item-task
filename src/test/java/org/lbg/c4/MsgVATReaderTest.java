package org.lbg.c4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MsgVATReaderTest {
    private MsgVATReader cut;

    @BeforeEach
    public void setUp() {
        ICustomPrompt customPrompt = new CustomPrompt();
        cut = new MsgVATReader(customPrompt);
    }

    @Test
    public void readFromKeyboard_valid_input() {
        String expectedResult = "22.0";
        System.setIn(new ByteArrayInputStream("22.0".getBytes()));

        String actualResult = cut.readFromKeyboard(System.in);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void readFromKeyboard_invalid_then_valid_input() {
        String expectedResult = "22";
        System.setIn(new ByteArrayInputStream("cheese".getBytes()));
        System.setIn(new ByteArrayInputStream("22".getBytes()));

        String actualResult = cut.readFromKeyboard(System.in);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void readFromKeyboard_quit_input() {
        String expectedResult = "QUIT";
        System.setIn(new ByteArrayInputStream("QUIT".getBytes()));

        String actualResult = cut.readFromKeyboard(System.in);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void isValid_input_valid_value() {
        boolean actualResult = cut.isValid("22.0");

        assertTrue(actualResult);
    }

    @Test
    public void isValid_input_invalid_value() {
        boolean actualResult = cut.isValid("cheese");

        assertFalse(actualResult);
    }

    @Test
    public void isValid_input_quit_value() {
        boolean actualResult = cut.isValid("QUIT");

        assertTrue(actualResult);
    }
}
