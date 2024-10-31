package org.lbg.shop;

import org.junit.jupiter.api.Test;
import org.lbg.shop.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void onConstruction_valid_balance_verify() {
        double expectedResult = 100.01;
        Calculator cut = new Calculator(expectedResult);

        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onConstruction_invalid_balance_verify() {
        double expectedResult = 0;
        double startingBalance = -1000;
        Calculator cut = new Calculator(startingBalance);

        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onAdd_verify_balance() {
        double startingBalance = 1000;
        double amount = 197.324;
        double expectResult = startingBalance + amount;
        Calculator cut = new Calculator(startingBalance);

        cut.add(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onSubtract_verify_balance() {
        double startingBalance = 1000;
        double amount = 197.324;
        double expectResult = startingBalance - amount;
        Calculator cut = new Calculator(startingBalance);

        cut.subtract(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onMultiply_verify_balance() {
        double startingBalance = 1000;
        double amount = 197.324;
        double expectResult = startingBalance * amount;
        Calculator cut = new Calculator(startingBalance);

        cut.multiply(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onDivide_verify_balance() {
        double startingBalance = 1000;
        double amount = 197.324;
        double expectResult = startingBalance / amount;
        Calculator cut = new Calculator(startingBalance);

        cut.divide(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onAdd_negative_result_verify_balance() {
        double startingBalance = 100;
        double amount = -197.324;
        double expectResult = startingBalance;
        Calculator cut = new Calculator(startingBalance);

        cut.add(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onSubtract_negative_result_verify_balance() {
        double startingBalance = 100;
        double amount = 197.324;
        double expectResult = startingBalance;
        Calculator cut = new Calculator(startingBalance);

        cut.subtract(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onMultiply_negative_result_verify_balance() {
        double startingBalance = 100;
        double amount = -197.324;
        double expectResult = startingBalance;
        Calculator cut = new Calculator(startingBalance);

        cut.multiply(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void onDivide_negative_result_verify_balance() {
        double startingBalance = 100;
        double amount = -197.324;
        double expectResult = startingBalance;
        Calculator cut = new Calculator(startingBalance);

        cut.divide(amount);
        double actualResult = cut.getBalance();

        assertEquals(expectResult,actualResult);
    }
}
