package proprieta;

import java.io.*;
import java.util.Properties;

public class StoreProperties {

        public static void main(String [] args){
            Properties prop = new Properties();
            OutputStream output=null;
            try{
                output = new FileOutputStream("C:\\Users\\Fides.NBK000FUL000000\\IdeaProjects\\gestionale_sportivo\\src\\proprieta\\file.properties");

                // set the properties value
                prop.setProperty("database", "localhost");
                prop.setProperty("dbuser", "melu");
                prop.setProperty("dbpassword", "password");

                // save properties to project root folder
                prop.store(output, null);





            }catch (Exception e){
                e.printStackTrace();
            }
            if (output!= null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


}
