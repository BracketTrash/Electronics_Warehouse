package electronics_wherehouse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This program implements an application that
 /** Takes in Strings from fields that contain user names and passwords that are then stored in a arraylist that is then saved in xml
 /** Method that allows user to return to previous scene
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class RegistrationController implements Initializable {
    @FXML
    PasswordField userPasswordField;

    @FXML
    TextField userNameField;

    @FXML
    TextField userPasswordConfirmField;
   ArrayList<Users> userList;

    private void registerUser(String userName, String userPassword){
        Users user = new Users(userName, userPassword);
        userList.add(user);
    }

    private void saveNewUser() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("Users.xml"));
        out.writeObject(userList);
        out.close();
    }
//
//    String pcheck1 = userPasswordField.getText();
//    String pcheck2 = userPasswordConfirmField.getText();
//    Boolean passwordCheck;
//
//    private boolean checkPassword() {
//        if (pcheck1 == pcheck2) {
//            return passwordCheck = true;
//        }
//        else {
//            return passwordCheck = false;
//        }
//    }

    @FXML private void createUser() throws Exception {
        try {
          //  if (userPasswordField.equals(userPasswordConfirmField)) {
                String userName = userNameField.getText();
                String userPassword = userPasswordField.getText();
                registerUser(userName, userPassword);
                saveNewUser();
           // } else {
             //   userPasswordField.clear();
            //    userPasswordConfirmField.clear();
            //    userNameField.clear();
        //    }
        }
            catch(Exception e){
                System.out.println("Error registering user: " + e);
            }

    }

    public void handleReturnButton(ActionEvent event) throws IOException {
        try {
                Parent registerScreenParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene registerScreen = new Scene(registerScreenParent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(registerScreen);
                stage.show();
        } catch (Exception e) {
            System.out.println("Error going back: " + e);
        }
    }

    @FXML
    public void loadUsers() throws Exception

    {

        XStream xstream = new XStream(new DomDriver());

        ObjectInputStream is = xstream.createObjectInputStream

                (new FileReader("Users.xml"));

        userList = (ArrayList<Users>) is.readObject();

        is.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadUsers();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
