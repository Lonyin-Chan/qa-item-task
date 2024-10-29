package org.lbg.c4;

import java.text.DecimalFormat;

public class Item {
    public int itemNo;
    public double cost;
    public int quantity;
    public double vat;

    private final DecimalFormat decfor = new DecimalFormat("0.00");


    public Item(int itemNo, double cost, int quantity, double vat) {
        this.itemNo = itemNo;
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
    }

    public double getTotalPrice() {
        return cost * (1+vat) * quantity;
    }

    public String toString() {
        return "Item " + itemNo + " total cost: £" + decfor.format(getTotalPrice());
    }

}
