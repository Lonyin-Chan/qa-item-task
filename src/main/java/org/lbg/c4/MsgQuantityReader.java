package org.lbg.c4;

import java.io.InputStream;
import java.util.Scanner;

public class MsgQuantityReader extends MsgReader implements IElementReader{
    public MsgQuantityReader(ICustomPrompt prompt) {
        super(prompt);
    }

    @Override
    public  String readFromKeyboard( InputStream is )
    {
        Scanner theScanner = new Scanner( is );
        String quantity = "";
        do {
            itsPrompt.prompt("Enter the quantity (Int):");
            quantity = theScanner.nextLine();
        } while (!isValid(quantity));
        return quantity;
    }

    @Override
    public boolean isValid(String str) {
        try {
            if (str.equalsIgnoreCase("QUIT")) return true;
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            itsPrompt.prompt("Enter a valid value!!!!");
            return false;
        }
    }
}
