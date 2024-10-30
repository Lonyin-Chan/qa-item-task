package org.lbg.shop;
public interface IDataStore{
    public Basket getItemsInDB();
    double getTotalPriceInDB();

    Item getLastItemSoldInDB();
}