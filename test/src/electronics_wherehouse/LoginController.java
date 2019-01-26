package electronics_wherehouse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This program implements an application that
 * does the following ................
/** Handles back button
 /** Allows users to login
 /** Allows admins to log in
 /** Allows users to be loaded
 *
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class LoginController implements Initializable {

    @FXML
    Label output1,output2;

    @FXML
    TextField userPassword, userName, adminName, adminPassword;

    private ArrayList<Admin> admins;
    private ArrayList<Users> userList;

    public void handleBackButton(ActionEvent event) throws IOException {
        Parent registerScreenParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene registerScreen = new Scene(registerScreenParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(registerScreen);
        stage.show();

    }

       // private ArrayList<Users> users =new ArrayList<>();

        @FXML
        private void handleAdminLoginButtonAction(ActionEvent event) throws Exception{
            String aName = adminName.getText();
            String aPassword = adminPassword.getText();

            if (aName.equals("admin") && aPassword.equals("password123") ) {
                Parent loginScreenParent = FXMLLoader.load(getClass().getResource("Admin2.fxml"));
                Scene loginScreen = new Scene(loginScreenParent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(loginScreen);
                stage.show();
            } else {
            adminName.clear();
            adminPassword.clear();
            }
        }

        @FXML
        private void handleUserLoginButtonAction(ActionEvent event) throws Exception{

            searchUserFunction(userName.getText(),userPassword.getText(),event);
        }

        private void searchUserFunction(String userName, String userPassword, ActionEvent event)//method for searching bmi
        {
            for(Users u:userList)//enhanced for loop:assigns m to members
                try{
                    if(u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword) )//if the bmi category that is searched matches the category switch statements
                    {
                        Parent productsScreenParent = FXMLLoader.load(getClass().getResource("UserScreen2.fxml"));
                        Scene productScreen = new Scene(productsScreenParent);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(productScreen);
                        stage.show();
                    }
                    else
                    {
                        output1.setText("User Does Not Exist");
                    }
                }
                catch(Exception e){
                    System.out.println("Error searching for user: " + e);
                }

        }

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

