package org.lbg.c4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomPromptTest {

    @Test
    public void prompt_test_message_print() {
            // Arrange
            String expectedResult = "[Testing]";
            CustomPrompt cut = new CustomPrompt();

            // Act
            ByteArrayOutputStream actualResult = new ByteArrayOutputStream();
            System.setOut(new PrintStream(actualResult));
            cut.prompt("Testing");

            // Assert
            assertEquals(expectedResult, actualResult.toString());

    }

    @Test
    public void prompt_test_message_with_null_value() {
        // Arrange
        CustomPrompt cut = new CustomPrompt();

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> cut.prompt(null));
    }
}
