package electronics_wherehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This program implements an application that
 * does the following ................
 /**Starts the initial stage
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setScene(new Scene(root, 905, 416));
        root.getStylesheets().addAll(this.getClass().getResource("css/style.css").toExternalForm());
        primaryStage.show();
        primaryStage.setTitle("Electronics Warehouse");
    }


    public static void main(String[] args) {
        launch(args);
    }

}




