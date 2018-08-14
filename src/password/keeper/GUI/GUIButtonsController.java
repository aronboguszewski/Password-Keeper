package password.keeper.GUI;

import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import password.keeper.entity.Account;
import password.keeper.logic.AddModuleEmptyValidator;
import password.keeper.logic.PasswordGenerator;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIButtonsController implements Initializable {

    @FXML private TableView<Account> accountTable;

    @FXML private TableColumn<Account, String> nameColumn;
    @FXML private TableColumn<Account, String> loginColumn;
    @FXML private TableColumn<Account, String> passwordColumn;

    @FXML TextField passwordField;
    @FXML TextField numberOfCharField;

    @FXML TextField nameAddField;
    @FXML TextField loginAddField;
    @FXML TextField passwordAddField;

    @FXML JFXToggleButton lowerToggle;
    @FXML JFXToggleButton upperToggle;
    @FXML JFXToggleButton digitsToggle;
    @FXML JFXToggleButton punctuationToggle;

    AddModuleEmptyValidator validator;

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
        validator = new AddModuleEmptyValidator();

        if(validator.checkIfFieldIsEmpty(nameAddField, loginAddField, passwordAddField)){
            Alert alert = new Alert(Alert.AlertType.NONE, "Fields cannot be empty!", ButtonType.OK);
            alert.setTitle("Error: empty fields");
            alert.showAndWait();
        }
        else {
            data.add(new Account(nameAddField.getText(), loginAddField.getText(), passwordAddField.getText()));
            nameAddField.clear();
            loginAddField.clear();
            passwordAddField.clear();
        }
    }

    @FXML
    public void deleteTableRowButton (javafx.event.ActionEvent actionEvent){
        Account selectedItem = accountTable.getSelectionModel().getSelectedItem();
        accountTable.getItems().remove(selectedItem);
    }

    @FXML
    public void generatePasswordButton (javafx.event.ActionEvent actionEvent){
        PasswordGenerator passwordGenerator =
                new PasswordGenerator(lowerToggle.isSelected(),
                                      upperToggle.isSelected(),
                                      digitsToggle.isSelected(),
                                      punctuationToggle.isSelected());

        if (numberOfCharField.getText().isEmpty()){
            passwordField.setText(passwordGenerator.generatePassword(7));
        }
        else{
            passwordField.setText(passwordGenerator.generatePassword(
                                  (Integer.parseInt(numberOfCharField.getText()))));
        }

    }

    @FXML
    public void moveButton (javafx.event.ActionEvent actionEvent){
            passwordAddField.setText(passwordField.getText());
    }


}
