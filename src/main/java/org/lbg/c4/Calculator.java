package org.lbg.c4;

public class Calculator {
    private double balance;

    public Calculator(double balance) {
        if (balance < 0)
            this.balance = 0;
        else
            this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void add(double value) {
        if (balance + value > 0)
            balance += value;
    }

    public void subtract(double value) {
        if (balance - value > 0)
            balance -= value;
    }

    public void multiply(double value) {
        if (balance * value > 0)
            balance *= value;
    }

    public void divide(double value) {
        if (balance / value > 0)
            balance /= value;
    }

}
