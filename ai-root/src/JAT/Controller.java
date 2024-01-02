package JAT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class Controller {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField tfKey_ID;

    @FXML
    private PasswordField tfSec_ID;

    @FXML
    void onBtnClick(ActionEvent event) {
        String title = tfKey_ID.getText();
        mainWindow.setTitle(title);
    }
    
    private Stage mainWindow;

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }
}
