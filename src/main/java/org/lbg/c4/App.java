package org.lbg.c4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.inputLogic();
    }

    public void inputLogic() {
        ICustomPrompt customPrompt = new CustomPrompt();
        MsgCostReader mcr = new MsgCostReader(customPrompt);
        MsgQuantityReader mqr = new MsgQuantityReader(customPrompt);
        MsgVATReader mvr = new MsgVATReader(customPrompt);

        ArrayList<IElementReader> readers = new ArrayList<>(2);
        readers.add(mcr);
        readers.add(mqr);
        readers.add(mvr);

        Runner runner = new Runner(readers);

        ArrayList<Item> items = runner.run();

        items.forEach(item -> {
            System.out.println(item);
        });
    }
}
