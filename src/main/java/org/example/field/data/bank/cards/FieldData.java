package org.example.field.data.bank.cards;

import org.example.Main;
import org.example.actions.ActionsWithAccount;

public class FieldData {

    public static void fieldData(String password, String numberCard, int sum){
        Main.data.add(new ActionsWithAccount(password, numberCard, sum));
    }
}
