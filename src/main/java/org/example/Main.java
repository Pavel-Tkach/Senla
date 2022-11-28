package org.example;

import org.example.Actions.ActionsWithAccount;
import org.example.Block.BlockBankCards;
import org.example.DataCards.ReadDataCards;
import org.example.DataCards.WriteDataCards;
import org.example.Login.Login;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int count = 0;
    public static boolean flag = true;
    public static ArrayList<ActionsWithAccount> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new ReadDataCards().readCardData("Bank_card_data.txt");
        while(flag && count != 3){
            inputNumberCard();
            new BlockBankCards().unblockCard();
        }

    }

    public static void inputNumberCard() throws IOException {
        System.out.println("Enter the number card: ");
        String numberCard = new Scanner(System.in).nextLine();

        ActionsWithAccount actionsWithAccount = new Login().findYourCard(numberCard);



        if (actionsWithAccount != null){
            inputPasswordAndCheck(actionsWithAccount);

            if (data.contains(actionsWithAccount)){ 
                chooseAction(actionsWithAccount);
            }
        }
    }

    public static void inputPasswordAndCheck(ActionsWithAccount actionsWithAccount) throws IOException {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter password: ");
            String password = new Scanner(System.in).nextLine();

            if (!new Login().checkPassword(actionsWithAccount, password)){
                System.out.println("Wrong password, try again !\n");
                count++;
                if (count == 3) {
                    data.remove(actionsWithAccount);
                    new BlockBankCards().setBlockCards(actionsWithAccount);
                    new WriteDataCards().writeCards();
                    System.out.println("Attempts ended, the card is blocked !\n");
                    inputNumberCard();
                }
            }
            else{
                return;
            }
        }
    }

    public static void chooseAction(ActionsWithAccount actionsWithAccount) throws IOException {
        int operationNumber = 0;
        System.out.println("""
                Select operation number:
                1. Check balance
                2. Withdraw money from the card
                3. Put money on the card
                4. Exit\n""");
        while(operationNumber < 1 || operationNumber > 4){
            operationNumber = new Scanner(System.in).nextInt();
            if (operationNumber < 1 || operationNumber > 4) System.out.println("Please, input correct operation number\n");
        }

        switch (operationNumber){
            case 1: actionsWithAccount.checkBalance();
                break;
            case 2: actionsWithAccount.withdrawMoney();
                break;
            case 3: actionsWithAccount.putMoney();
                break;
            case 4:
                new WriteDataCards().writeCards();
                flag = false;
                break;
        }
    }
}
