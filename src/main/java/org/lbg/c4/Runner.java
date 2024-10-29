package org.lbg.c4;

import java.util.ArrayList;

public class Runner {
    private final ArrayList<IElementReader> itsReaders;

    public  Runner( ArrayList<IElementReader> readers )
    {
        itsReaders = readers;
    }

    public  ArrayList<Item>    run() {
        String lineRead = "";

        ArrayList<String> itemParams = new ArrayList<>(3);
        ArrayList<Item> items = new ArrayList(10);

        exitApp:
        while (lineRead != null) {
            for (var reader : itsReaders) {
                lineRead = reader.readFromKeyboard(System.in);
                if (lineRead.equalsIgnoreCase("QUIT")) {
                    break exitApp;
                }
                itemParams.add(lineRead);
            }
            Item item = new Item(itemParams.get(0), itemParams.get(1), itemParams.get(2));
            items.add(item);
            itemParams.clear();
        }

        return items;
    }
}
