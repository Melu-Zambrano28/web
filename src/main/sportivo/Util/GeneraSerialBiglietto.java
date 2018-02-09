package main.sportivo.Util;

import java.util.UUID;

public class GeneraSerialBiglietto {
    private static UUID seriale;
    private static String serialeString;


    //generatore di seriali
    public static String getSeriale(){
        seriale=UUID.randomUUID(); //ogg
        serialeString =seriale.toString(); //string cast
        return serialeString; //return string

    }
}
