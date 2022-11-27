package org.example.Block;

import org.example.Actions.ActionsWithAccount;
import org.example.Main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BlockBankCards {

    private ArrayList<ActionsWithAccount> blockCards = new ArrayList<>();

    public ArrayList<ActionsWithAccount> getBlockCards() {
        return blockCards;
    }

    public void setBlockCards(ActionsWithAccount actionsWithAccount) {
        blockCards.add(actionsWithAccount);
    }

    public void unblockCard(){
        LocalDate date = LocalDate.now();
        LocalDate dateBack = date.plusDays(1);
        if (date == dateBack){
            blockCards.remove(0);
            Main.data.add(blockCards.get(0));
        }
    }
}
