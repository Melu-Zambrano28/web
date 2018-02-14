package proprieta;
 //load
import java.io.*;
import java.util.Properties;

public class LeggiFileProperties {

    public static void main(String [] args){
        Properties prop = new Properties();
        InputStream  input=null;
        try{

            input = new FileInputStream("C:\\Users\\Fides.NBK000FUL000000\\IdeaProjects\\gestionale_sportivo\\src\\proprieta\\file.properties");

            // load a properties file
            prop.load(input);
            // set the properties value
            System.out.println(prop.getProperty("urlDatabase"));
            System.out.println(prop.getProperty("databaseUser"));
            System.out.println(prop.getProperty("databasePw"));



        }catch (Exception e){
            e.printStackTrace();
        }
        if (input != null) {
            try {
               input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
