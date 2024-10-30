package org.lbg.c4;

import org.lbg.shop.BankAccount;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(20000);
        System.out.println(ba.getBalance());
        ba.credit(2000);
        ba.debit(200);
        System.out.println(ba.getBalance());

//        App app = new App();
//        app.appLogic();
    }

    public void appLogic() {
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

        System.out.println("-------------- Receipt --------------");
        items.forEach(System.out::println);
    }
}