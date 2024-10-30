package org.lbg.shop;
public class DataStore implements IDataStore{    // Simulate the idea of data being loaded from persistent storage
     @Override
     public Basket getItemsInDB()    {
         Basket basket = new Basket();
         Item item1 = new Item("Bananas", 6, 0.19);
         Item item2 = new Item("Avocado", 3, 0.89); // 2.67
         Item item3 = new Item("Spinach", 1, 1.27); // 1.27
         basket.addItem(item1);
         basket.addItem(item2);
         basket.addItem(item3);
         throw new RuntimeException("We should never get here, we are simulating a call out of the application");
     }
}