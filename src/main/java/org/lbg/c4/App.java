package org.lbg.c4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static double totalCost = 0;
    private final DecimalFormat decfor = new DecimalFormat("0.00");
    private ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();
        app.inputLogic();
    }

    public void inputLogic() {
        try (Scanner myScanner = new Scanner(System.in)) {
            System.out.println("Enter VAT rate:");
            double vat = Double.parseDouble(myScanner.nextLine());

            while (true) {
                String itemCost = getUserInput(myScanner, "Enter item cost or quit (Enter QUIT): ");
                if (itemCost.equalsIgnoreCase("QUIT")) {
                    break;
                }

                String itemQuantity = getUserInput(myScanner, "Enter item quantity or quit (Enter QUIT): ");
                if (itemQuantity.equalsIgnoreCase("QUIT")) {
                    break;
                }

                processItem(Double.parseDouble(itemCost), Integer.parseInt(itemQuantity), vat);
                System.out.println("Current total cost: £" + decfor.format(totalCost));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        printResult();
    }

    private String getUserInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? getUserInput(scanner, prompt) : input;
    }

    private void printResult() {
        System.out.println("Final total cost is: £" + decfor.format(totalCost));
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item " + (i + 1) + " costs: £" + decfor.format(items.get(i).getTotalPrice()));
        }
    }

    private void processItem(double cost, int quantity, double vat) {
        Item newItem = new Item(cost, quantity, vat);
        items.add(newItem);
        totalCost += newItem.getTotalPrice();
    }
}
