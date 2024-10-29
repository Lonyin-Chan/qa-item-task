package org.lbg.c4;

import java.io.InputStream;
import java.util.Scanner;

public class MsgCostReader extends MsgReader implements IElementReader{

    public MsgCostReader(ICustomPrompt prompt) {
        super(prompt);
    }

    @Override
    public  String readFromKeyboard( InputStream is )
    {
        Scanner theScanner = new Scanner( is );
        String cost = "";

        do {
            itsPrompt.prompt("Enter the item cost (Double):");
            cost = theScanner.nextLine();
        } while (!isDouble(cost));

        return cost;
    }

    private boolean isDouble(String str) {
        try {
            if (str.equals("QUIT")) return true;
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            itsPrompt.prompt("Enter a valid value!!!!");
            return false;
        }
    }
}
