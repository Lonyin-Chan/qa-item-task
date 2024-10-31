package org.lbg.c4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
