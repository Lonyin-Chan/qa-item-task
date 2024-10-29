package org.lbg.c4;

import java.io.InputStream;
import java.util.Scanner;

public class MsgVATReader extends MsgReader implements IElementReader {
    public MsgVATReader(ICustomPrompt prompt) {
        super(prompt);
    }

    @Override
    public String readFromKeyboard(InputStream is) {
        Scanner theScanner = new Scanner(is);
        String vat = "";

        do {
            itsPrompt.prompt("Enter the VAT (Double):");
            vat = theScanner.nextLine();
        } while(!isDouble(vat));

        return vat;
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
