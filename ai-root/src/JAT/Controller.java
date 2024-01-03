package JAT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Controller {


    
    @FXML
    private Button btnLightMode;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField tfKey_ID;

    @FXML
    private PasswordField tfSec_ID;

    @FXML
    
    void btnLightSwitch(ActionEvent event) {
        
        double opacity = mainWindow.getOpacity() == 1.0 ? 0.2 : 1.0;
        mainWindow.setOpacity(opacity);
        String btnText = btnLightMode.getText().equals("Light") ? "Dark" : "Light";
        btnLightMode.setText(btnText);

    }
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


