/*import net.jacobpeterson.alpaca.AlpacaAPI;
import javafx.*;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ai {

    // init logger
    public static final Logger botLogger = LoggerFactory.getLogger(ai.class);

    public static void main(String[] args) {
        
        AlpacaController.connect();
        
        // Get acc details
        AlpacaController.startListeningForTSLATrades();
        /*AlpacaController.logRecentData("AMD");

        AlpacaController.logAccCash();
        AlpacaController.logCreateDate();
        AlpacaController.logPortValue();
        AlpacaController.logStatus();
        AlpacaController.placeTrade();
        /* log test
            botLogger.info("This is an informational message.");
            botLogger.warn("This is a warning message.");
            botLogger.error("This is an error message.");*/

        }


    
}
