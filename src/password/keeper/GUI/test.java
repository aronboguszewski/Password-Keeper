package password.keeper.GUI;

import password.keeper.logic.PasswordGenerator;

public class test {

    public static void main(String[] args) {

        PasswordGenerator pg = new PasswordGenerator(true, false, false, true);
        System.out.print(pg.generatePassword(15));
    }
}
