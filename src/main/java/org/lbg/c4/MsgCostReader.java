package org.lbg.c4;

import java.io.InputStream;
import java.util.Scanner;

public class MsgCostReader extends MsgReader implements IElementReader{

    public MsgCostReader(ICustomPrompt prompt) {
        super(prompt);
    }

    @Override
    public  String readFromKeyboard( InputStream is ) {
        Scanner theScanner = new Scanner( is );
        String cost = "";
        do {
            itsPrompt.prompt("Enter the item cost (Double):");
            cost = theScanner.nextLine();
        } while (!isValid(cost));
        return cost;
    }

    @Override
    public boolean isValid(String str) {
        try {
            if (str.equalsIgnoreCase("QUIT")) return true;
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            itsPrompt.prompt("Enter a valid value!!!!");
            return false;
        }
    }
}
