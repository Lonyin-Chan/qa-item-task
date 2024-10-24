package org.lbg.c4;

public class Item {
    public double cost;
    public int quantity;
    public double vat;

    public Item(double cost, int quantity, double vat) {
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
    }

    public double getTotalPrice() {
        return cost * (1+vat) * quantity;
    }
}
