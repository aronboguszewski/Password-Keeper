package password.keeper.entity;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Account implements Serializable {

    private final SimpleStringProperty name;
    private final SimpleStringProperty login;
    private final SimpleStringProperty password;


    public Account(String name, String login, String password) {
        this.name = new SimpleStringProperty(name);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
