package src;

import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.model.endpoint.account.Account;
import net.jacobpeterson.alpaca.rest.AlpacaClientException;




public class AlpacaController {

    public static void main(String[] args) {
        // This constructor uses the 'alpaca.properties' file on the classpath for configuration
        AlpacaAPI alpacaAPI = new AlpacaAPI();

        try {
                // Get 'Account' information and print it out
                Account account = alpacaAPI.account().get();
                System.out.println(account);
            } 
        catch (AlpacaClientException exception) {
                exception.printStackTrace();
}

    }

    public static void getAccount() {
        AlpacaAPI alpacaAPI = new AlpacaAPI();
        Account account = AlpacaAPI.account().get();

        
    }


}


