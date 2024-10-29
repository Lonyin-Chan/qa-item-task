package org.lbg.c4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void onConstruction_verify_object_initialised_correctly() {
        double expectedResult = 34.75;
        BankAccount cut = new BankAccount(expectedResult);

        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onConstruction_negative_value() {
        double expectedResult = -10000;
        BankAccount cut = new BankAccount(expectedResult);

        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onCredit_verify_balance() {
        double startingBalance = 50.56;
        double creditAmount = 20.21;
        double expectedResult = creditAmount + startingBalance;
        BankAccount cut = new BankAccount(startingBalance);

        cut.credit(creditAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_verify_balance() {
        double startingBalance = 50.56;
        double debitAmount = 20.21;
        double expectedResult = startingBalance - debitAmount;
        BankAccount cut = new BankAccount(startingBalance);

        cut.debit(debitAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onCredit_credit_invalid_zero_verify_balance() {
        double startingBalance = 50.56;
        double creditAmount = 0;
        double expectedResult = startingBalance;
        BankAccount cut = new BankAccount(startingBalance);

        cut.credit(creditAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_debit_invalid_zero_verify_balance() {
        double startingBalance = 50.56;
        double debitAmount = 0;
        double expectedResult = startingBalance;
        BankAccount cut = new BankAccount(startingBalance);

        cut.debit(debitAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_debit_below_invalid_verify_balance() {
        double startingBalance = 50.56;
        double debitAmount = 70.21;
        double expectedResult = startingBalance;
        BankAccount cut = new BankAccount(startingBalance);

        cut.debit(debitAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_debit_negative() {
        double startingBalance = 1000;
        double debitAmount = -1001;
        double expectedResult = startingBalance - debitAmount;
        BankAccount cut = new BankAccount(startingBalance);

        cut.debit(debitAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onCredit_credit_negative() {
        double startingBalance = 50.56;
        double creditAmount = -20.21;
        double expectedResult = startingBalance;
        BankAccount cut = new BankAccount(startingBalance);

        cut.credit(creditAmount);
        double actualResult = cut.getBalance();

        assertEquals(expectedResult, actualResult);
    }

}
