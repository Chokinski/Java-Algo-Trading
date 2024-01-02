package JAT;
import java.lang.reflect.InvocationTargetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JATbot extends Application {

    // init logger
    public static final Logger botLogger = LoggerFactory.getLogger(JATbot.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscene.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setMainWindow(primaryStage);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {

        try {
            launch(args);
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                ((InvocationTargetException) e).getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }
        }

        /*
         * log test
         * AlpacaController.logRecentData("AMD");
         * AlpacaController.logAccCash();
         * AlpacaController.logCreateDate();
         * AlpacaController.logPortValue();
         * AlpacaController.logStatus();
         * AlpacaController.placeTrade();
         * botLogger.info("This is an informational message.");
         * botLogger.warn("This is a warning message.");
         * botLogger.error("This is an error message.");
         */

    }

}
