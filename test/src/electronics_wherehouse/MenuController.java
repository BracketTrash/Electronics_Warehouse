package electronics_wherehouse;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This program implements an application that
 * does the following ................
 /** allows user to access registration or to login
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class MenuController {

    public void handleRegistrationButton(ActionEvent event) throws IOException {
        Parent registerScreenParent = FXMLLoader.load(getClass().getResource("Reg2.fxml"));
        Scene registerScreen = new Scene(registerScreenParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(registerScreen);
        stage.show();
    }

    public void handleLoginButton(ActionEvent event) throws IOException {
        Parent loginScreenParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene loginScreen = new Scene(loginScreenParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginScreen);
        stage.show();
    }

    }
