package org.lbg.shop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Session
{
    // Simulate the idea of data being loaded from persistent storage
    private IDataStore dataStore;

    public Session( IDataStore dataStore )
    {
        this.dataStore = dataStore;
    }

    public String   getItems()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Basket basket = dataStore.getItemsInDB();
        String result = "";
        try
        {
            result = objectMapper.writeValueAsString(basket);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public String getTotalPrice() {
        ObjectMapper objectMapper = new ObjectMapper();
        double basketTotalPrice = dataStore.getTotalPriceInDB();
        String result = "";
        try
        {
            result = objectMapper.writeValueAsString(basketTotalPrice);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public String getTheLastItemSold() {
        ObjectMapper objectMapper = new ObjectMapper();
        Item lastItemSold = dataStore.getLastItemSoldInDB();
        String result = "";
        try
        {
            result = objectMapper.writeValueAsString(lastItemSold);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

}