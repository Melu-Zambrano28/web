package it.fides.sportivo.Util;

import java.util.UUID;

public class GeneraSerialBiglietto {
    private static UUID seriale;
    private static String serialeString;


    //generatore di seriali
    public static String getSeriale(){
        seriale=UUID.randomUUID();
        serialeString =seriale.toString();
        return serialeString;

    }
}
