package src;

import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.account.Account;
import net.jacobpeterson.alpaca.rest.AlpacaClientException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class AlpacaController {
    private static AlpacaAPI alpaca;

    /**
     * Connects to the Alpaca API using the properties specified in the "alpaca.properties" file.
     * If the file or path is not found, a FileNotFoundException is thrown.
     * If an IO exception occurs while loading the properties, an IOException is thrown.
     */
    public static void connect()
    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\alpaca.properties"));
            alpaca = new AlpacaAPI();
            
        } catch (FileNotFoundException exception) {
            ai.botLogger.error("Erorr, File/Path Not Found:"+ exception.getMessage());
        } catch (IOException exception) {
            ai.botLogger.error("Erorr, IO Exception:"+ exception.getMessage());
        }
        
    }

    public static Account getAccount() {
        try {
                // Get 'Account' information and print it out
                Account account = alpaca.account().get();
                return account;
            } 
        catch (AlpacaClientException exception) {
                ai.botLogger.error("Error getting acc info: " + exception.getMessage());
                return null;
    }
    
}


}