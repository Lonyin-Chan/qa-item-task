package org.lbg.c4;

import java.text.DecimalFormat;

public class Item {
    public String cost;
    public String quantity;
    public String vat;

    private final DecimalFormat decfor = new DecimalFormat("0.00");


    public Item(String cost, String quantity, String vat) {
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
    }

    public double getTotalPrice() {
        return Double.parseDouble(cost) * (1+Double.parseDouble(vat)) * Integer.parseInt(quantity);
    }

    public String toString() {
        return "Item total cost: £" + decfor.format(getTotalPrice());
    }

}
