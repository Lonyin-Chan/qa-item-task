package org.lbg.c4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MsgCostReaderTest {

    private MsgCostReader cut;

    @BeforeEach
    public void setUp() {
        ICustomPrompt customPrompt = new CustomPrompt();
        cut = new MsgCostReader(customPrompt);
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

}
