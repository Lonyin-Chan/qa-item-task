package org.lbg.c4;

import java.io.InputStream;

public interface IElementReader {
    public  String readFromKeyboard(InputStream is);

    boolean isValid(String str);
}
