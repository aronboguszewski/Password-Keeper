package password.keeper.logic;


import javafx.scene.control.TextField;

public class AddModuleEmptyValidator {

    public boolean checkIfFieldIsEmpty(TextField nameAddField,
                                       TextField loginAddField,
                                       TextField passwordAddField)
    {
        boolean isEmpty = false;

        if(nameAddField.getText().isEmpty() || loginAddField.getText().isEmpty() || passwordAddField.getText().isEmpty()){
            isEmpty = true;
        }
        return isEmpty;
    }
}
