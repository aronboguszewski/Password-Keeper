package password.keeper.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import password.keeper.entity.Account;

public class Main extends Application {
   // private TableView <Account> accountTable;

    @Override
    public void start(Stage primaryStage) throws Exception{

      //  accountTable = new TableView<Account>();


        Parent root = FXMLLoader.load(getClass().getResource("PasswordKeeperGUI.fxml"));

        primaryStage.setTitle("Password Keeper");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
