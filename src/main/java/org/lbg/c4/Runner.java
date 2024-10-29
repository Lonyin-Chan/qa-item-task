package org.lbg.c4;

import java.util.ArrayList;

public class Runner {
    private final ArrayList<IElementReader> itsReaders;

    public  Runner( ArrayList<IElementReader> readers )
    {
        itsReaders = readers;
    }

    public  ArrayList<Item>    run() {
        int itemNo = 0;
        String lineRead = "";
        ArrayList<String> itemParams = new ArrayList<>(3);
        ArrayList<Item> items = new ArrayList<>(10);

        exitApp: while (true) {
            for (var reader : itsReaders) {
                lineRead = reader.readFromKeyboard(System.in);
                if (lineRead.equalsIgnoreCase("QUIT")) {
                    break exitApp;
                }
                itemParams.add(lineRead);
            }
            items.add(new Item(++itemNo, Double.parseDouble(itemParams.get(0)),
                    Integer.parseInt(itemParams.get(1)), Double.parseDouble(itemParams.get(2))));
            itemParams.clear();
        }
        return items;
    }
}
