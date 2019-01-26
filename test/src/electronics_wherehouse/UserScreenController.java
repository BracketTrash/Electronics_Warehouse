package electronics_wherehouse;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.ObjectInputStream;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * This program implements an application that
 * does the following ................
/** allows user to see products
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class UserScreenController implements Initializable {

    @FXML
    TextArea feedBackField;
    private ArrayList<Product> products;


    public ArrayList<Product> getProducts() {
        return products;
    }

    public int amountOfProducts(){
        return products.size();
    }

    private String listOfProducts() throws Exception{
        loadProducts();
        if(products.size() > 0) {
            String listOfProducts = "";
            for (int i = 0; i < amountOfProducts(); i++){
                listOfProducts += i + ":" + products.get(i) + "\n";
            }
            return listOfProducts;
        }
        else{
            return "There are no products";
        }
    }

    @FXML private void listProducts() throws Exception{
        try{
            loadProducts();
        }catch(java.lang.reflect.InvocationTargetException e){
            System.out.println(e);
        }
        feedBackField.setText(listOfProducts());
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
            loadProducts();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

