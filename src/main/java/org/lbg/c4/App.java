package org.lbg.c4;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    static double totalCost = 0;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    private static double[] itemPrices = new double[0];
    public static void main(String[] args){

        try {
            Scanner myScanner = new Scanner(System.in);

            System.out.println("Enter VAT rate");

            double vat = Double.parseDouble(myScanner.nextLine());
            String input = "";
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
        Arrays.sort(itemPrices);

        System.out.println("Final total cost is: £" + decfor.format(totalCost));
//        System.out.println(Arrays.toString(itemPrices));
        printPrices();
    }

    public static void printPrices() {
        for (int i = 0; i < itemPrices.length; i++) {
            System.out.println("Item " + (i + 1) + " costs: £" + decfor.format(itemPrices[i]));
        }
    }

    public static void addToArray(double price) {
        double[] newList;
        newList = Arrays.copyOf(itemPrices, itemPrices.length + 1);
        newList[newList.length - 1] = price;
        itemPrices = newList;
    }

    public static double totalPrice(double cost, double vat) {
        return cost * (1 + vat);
    }
}
