package frontend.application;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import frontend.application.App;
import backend.*;



public class LoginController implements Initializable {
    @FXML
    private Label lbl_error;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    private TextArea studentProgress;

    @FXML
    void LoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();
        RoadmapApplication application = RoadmapApplication.getInstance();

        if (!application.login(username,password)) {
            lbl_error.setText("Invalid login credentials!");
            return;
        } else {

        if (application.getActiveUser() == null) {
            String advisorType = application.getAdvisorType();
            if ("advisor".equalsIgnoreCase(advisorType)) {
                App.setRoot("advisorHome");
               
            } else {
                lbl_error.setText("Invalid user type!");
                return;
            }
        } else {
            String userType = application.getUserType();

            if ("student".equalsIgnoreCase(userType)) {
                App.setRoot("studentHome");
            } else {
                String advisorType = application.getAdvisorType();
    
                if ("advisor".equalsIgnoreCase(advisorType)) {
                App.setRoot("advisorHome");
                } else {
                    lbl_error.setText("Invalid user type!");
                }
            }

        }

        
    }
}

    @FXML
    void SignUpClicked(MouseEvent event) throws IOException {
        App.setRoot("signup");

  
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}


 