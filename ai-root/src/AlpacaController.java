package src;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.account.Account;
import net.jacobpeterson.alpaca.rest.AlpacaClientException;

public class AlpacaController {
    private static AlpacaAPI alpaca;

    public static void connect()
    {
        AlpacaAPI alpaca = new AlpacaAPI();
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