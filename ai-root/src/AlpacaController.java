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
            properties.load(new FileInputStream("ai-root\\alpaca.properties"));
            String keyID = properties.getProperty("key_id");
            String secretKey = properties.getProperty("secret_key");
            alpaca = new AlpacaAPI(keyID,secretKey);
            
        } catch (FileNotFoundException exception) {
            ai.botLogger.error("Erorr, File/Path Not Found:"+ exception.getMessage());
        } catch (IOException exception) {
            ai.botLogger.error("Erorr, IO Exception:"+ exception.getMessage());
        }
        
    }

    public static Account getAccount() {
        try {
                // Get 'Account' information
                Account account = alpaca.account().get();
                return account;
            } 
        catch (AlpacaClientException exception) {
                ai.botLogger.error("Error getting acc info: " + exception.getMessage());
                return null;
    }
    
}

public static void logAccCash() {
    ai.botLogger.info("Account Cash: {}",AlpacaController.getAccount().getCash());
    System.out.println("Cash Logged"+"\n\n\n");
}

public static void logPortValue() {
    ai.botLogger.info("Portfolio Value: {}",AlpacaController.getAccount().getPortfolioValue());
    System.out.println("Portfolio Value Logged"+"\n\n\n");

}

public static void logStatus() {
    ai.botLogger.info("Account Status: {}",AlpacaController.getAccount().getStatus());
    System.out.println("Account Status Logged"+"\n\n\n");

}

public static void logCreateDate() {
    ai.botLogger.info("Date Created: {}",AlpacaController.getAccount().getCreatedAt());
    System.out.println("Date Created"+"\n\n\n");

}




}