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

    private static ArrayList<Item> items = new ArrayList<>();
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        String itemCost = "";
        String itemQuantity = "";

        try {
            System.out.println("Enter VAT rate");
            double vat = Double.parseDouble(myScanner.nextLine());

            while (true) {
                System.out.println("Enter item cost or quit (Enter QUIT): ");
                itemCost = myScanner.nextLine();
                if (itemCost.isEmpty()) {
                    continue;
                }
                if (itemCost.equals("QUIT")) {
                    break;
                }

                System.out.println("Enter item quantity or quit (Enter QUIT): ");
                itemQuantity = myScanner.nextLine();
                if (itemQuantity.isEmpty()) {
                    continue;
                }
                if (itemQuantity.equals("QUIT")) {
                    break;
                }
               
                processItem(Double.parseDouble(itemCost), Integer.parseInt(itemQuantity), vat);
                System.out.println("Current total cost: £" + decfor.format(totalCost));
            }
            myScanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        printResult();
    }

    public static void printResult() {
        System.out.println("Final total cost is: £" + decfor.format(totalCost));
        printPrices();
    }

    public static void printPrices() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item " + (i + 1) + " costs: £" + decfor.format(items.get(i).getTotalPrice()));
        }
    }

    public static void processItem(double cost, int quantity, double vat) {
        Item newItem = new Item(cost, quantity, vat);
        items.add(newItem);

        totalCost += newItem.getTotalPrice();
    }
}
