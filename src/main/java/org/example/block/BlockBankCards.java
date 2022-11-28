package org.example.block;

import org.example.actions.ActionsWithAccount;
import org.example.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlockBankCards {

    private List<ActionsWithAccount> blockCards = new ArrayList<>();

    public void setBlockCards(ActionsWithAccount actionsWithAccount) {
        blockCards.add(actionsWithAccount);
    }

    public void unblockCard(){
        LocalDate date = LocalDate.now();
        LocalDate dateBack = date.plusDays(1);
        for (int i = 0; i < blockCards.size(); i++) {
            if (date == dateBack){
                blockCards.remove(blockCards.get(i));
                Main.data.add(blockCards.get(i));
            }
        }
    }
}
