package password.keeper.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import password.keeper.entity.Account;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIButtonsController implements Initializable {

    @FXML private TableView<Account> accountTable;

    @FXML private TableColumn<Account, String> nameColumn;
    @FXML private TableColumn<Account, String> loginColumn;
    @FXML private TableColumn<Account, String> passwordColumn;

    @FXML TextField nameAddField;
    @FXML TextField loginAddField;
    @FXML TextField passwordAddField;



    private final ObservableList<Account> data =
            FXCollections.observableArrayList(new Account("Gmail", "login1", "pass1"),
                                              new Account("Facebook", "loginF", "passF"),
                                              new Account("YouTube","loginY", "passY"),
                                              new Account("Wykop", "loginW", "passW")
                                            );

    @Override
    public void initialize (URL url, ResourceBundle rb){
        nameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("login"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));
        accountTable.setItems(data);
    }


    @FXML
    public void addButtonAction (javafx.event.ActionEvent actionEvent){
        data.add(new Account(nameAddField.getText(), loginAddField.getText(), passwordAddField.getText()));
        nameAddField.clear();
        loginAddField.clear();
        passwordAddField.clear();
    }


}
