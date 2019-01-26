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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This program implements an application that
 * does the following ................
 /** allows admin to see user
 /** allows admin to see products
 /** allows admin to add users
 /** allows admin to add products
 /** allows admin to remove products
 /** allows admin to remove users
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class AdminController implements Initializable {

    private ArrayList<Product> products;
    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    TextField descriptionField;
    @FXML
    TextField costField;
    @FXML
    TextField categoryField;

    @FXML
    TextArea feedBackField;
    @FXML
    TextArea feedBackFieldUsers;
    @FXML
    TextField userIdField;
    @FXML
    TextField userNameField;
    @FXML
    TextField userPasswordField;

    @FXML
    TextField removeProductField;
    @FXML
    TextField removeUserField;

    private ArrayList<Users> userList;

    public AdminController() {
        products = new ArrayList<Product>();
        userList = new ArrayList<Users>();
    }

    public void addProduct(int productId, String productName, String productDescription, double productCost, String productCategory){
       Product product = new Product(productId, productName, productDescription, productCost, productCategory);
        products.add(product);
    }

    public int numberOfProducts(){
        return products.size();
    }

    @FXML private void createProduct() throws Exception{
        int productId = Integer.parseInt(idField.getText());
        String productName = nameField.getText();
        String productDescription = descriptionField.getText();
        double productCost = Double.valueOf(costField.getText());
        String category = categoryField.getText();
        addProduct(productId,productName, productDescription, productCost, category);
        saveNewProduct();
    }

    @FXML
    public void removeProduct() throws Exception//creates the remove method that takes in a integer called index
    {
        int index = Integer.parseInt(removeProductField.getText());//gets the string entered in the field
        loadProducts();//loads the product array
        try {

            if (index>products.size())//if the index is higher than the array size
            {
                System.out.println("there is no products for this index number");//tells the user there's no product to remove
            }
            else {
                products.remove(index);//deletes the index number entered from the corresponding slot on the array
                System.out.println("Product deleted");//tells user the product was deleted
                saveNewProduct();//saves the new array without the deleted products
            }
        }
        catch(Exception e){
            System.out.println("Error removing a member: " + e);
        }
    }

    @FXML
    public void handleReturnButton(ActionEvent event) throws IOException {
        try {
            Parent registerScreenParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene registerScreen = new Scene(registerScreenParent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(registerScreen);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error going back: " + e);
        }
    }

    @FXML void listProducts() throws Exception{
        try{
            loadProducts();
        }catch(java.lang.reflect.InvocationTargetException e){
            System.out.println(e);
        }
        feedBackField.setText(listOfProducts());
    }

    private String listOfProducts() throws Exception{
        loadProducts();
        if(products.size() > 0) {
            String listOfProducts = "";
            for (int i = 0; i < numberOfProducts(); i++){
                listOfProducts += i + ":" + products.get(i) + "\n";
            }
            return listOfProducts;
        }
        else{
            return "There are no products";
        }
    }

    public void addUser(int userId, String userName, String userPassword) {
        Users user = new Users(userId, userName, userPassword);
        userList.add(user);
    }

    @FXML void listUsers() throws Exception{
        try{
            loadUsers();
        }catch(java.lang.reflect.InvocationTargetException e){
            System.out.println(e);
        }
        feedBackFieldUsers.setText(listOfUsers());
    }

    public int numberOfUsers(){
        return userList.size();
    }

    private String listOfUsers() throws Exception{
        loadUsers();
        if(userList.size() > 0) {
            String listOfUsers = "";
            for (int i = 0; i < numberOfUsers(); i++){
                listOfUsers += i + ":" + userList.get(i) + "\n";
            }
            return listOfUsers;
        }
        else{
            return "There are no users";
        }
    }

   @FXML private void createUser() throws Exception{
        String userName = userNameField.getText();
        int userId =  Integer.parseInt(userIdField.getText());
        String userPassword = userPasswordField.getText();
        addUser(userId, userName, userPassword);
        saveNewUser();
    }

    @FXML
    public void removeUser() throws Exception//creates the remove method that takes in a integer called index
    {
        int index = Integer.parseInt(removeUserField.getText());//gets the string entered in the field
        loadUsers();//loads the Users array
        try {

            if (index>userList.size())//if the index is higher than the array size
            {
                System.out.println("there is no products for this index number");//tells the user there's no product to remove
            }
            else {
                userList.remove(index);//deletes the index number entered from the corresponding slot on the array
                System.out.println("Product deleted");//tells user the product was deleted
                saveNewUser();//saves the new array without the deleted products
            }
        }
        catch(Exception e){
            System.out.println("Error removing a member: " + e);
        }
    }

    @FXML
    public void saveNewUser() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("Users.xml"));
        out.writeObject(userList);
        out.close();
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

    public void saveNewProduct() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("Products.xml"));
        out.writeObject(products);
        out.close();
    }

    public void loadProducts() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("Products.xml"));
        products = (ArrayList<Product>) is.readObject();
        is.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadUsers();
            loadProducts();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
