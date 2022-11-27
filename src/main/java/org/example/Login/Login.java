package org.example.Login;

import org.example.Actions.ActionsWithAccount;
import org.example.Main;

public class Login {

    public ActionsWithAccount findYourCard(String numberCard){
        for (int i = 0; i < Main.data.size(); i++) {
            if (Main.data.get(i).getNumberCard().equals(numberCard)){
                return Main.data.get(i);
            }
        }
        System.out.println("Wrong number card , try again !");
        return null;
    }

    public boolean checkPassword(ActionsWithAccount actionsWithAccount, String password){
        return password.equals(actionsWithAccount.getPassword());
    }
}
