package org.lbg.c4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    static double totalCost = 0;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    private static ArrayList<Double> itemPrices = new ArrayList<>();
    public static void main(String[] args){

        try {
            Scanner myScanner = new Scanner(System.in);
            String input = "";

            System.out.println("Enter VAT rate");
            double vat = Double.parseDouble(myScanner.nextLine());

            while (true) {
                System.out.println("Enter item cost or quit (Enter QUIT): ");
                input = myScanner.nextLine();
                if (input.isEmpty()) {
                    continue;
                }
                if (input.equals("QUIT")) {
                    break;
                }
                addToArray(Double.parseDouble(input));
                totalCost += totalPrice(Double.parseDouble(input), vat);
                System.out.println("Current total cost: £" + decfor.format(totalCost));
            }
            myScanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Final total cost is: £" + decfor.format(totalCost));
        Collections.sort(itemPrices);
        printPrices();
    }

    public static void printPrices() {
        for (int i = 0; i < itemPrices.size(); i++) {
            System.out.println("Item " + (i + 1) + " costs: £" + decfor.format(itemPrices.get(i)));
        }
    }

    public static void addToArray(double price) {
        itemPrices.add(price);
    }

    public static double totalPrice(double cost, double vat) {
        return cost * (1 + vat);
    }
}
