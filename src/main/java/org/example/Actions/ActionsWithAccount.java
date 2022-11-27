package org.example.Actions;

import org.example.ATM;
import org.example.Main;

import java.io.IOException;
import java.util.Scanner;

public class ActionsWithAccount extends ATM {
    private int sum;

    public ActionsWithAccount(String password, String numberCard, int sum) {
        super(password, numberCard);
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void checkBalance() throws IOException {
        System.out.println("Your balance = " + this.getSum());
        Main.chooseAction(this);
    }

    public void withdrawMoney() throws IOException {
        System.out.println("Enter the amount you want to withdraw : ");
        int amount = new Scanner(System.in).nextInt();
        if (amount > this.getSum()){
            System.out.println("Warning ! Insufficient funds");
            Main.chooseAction(this);
        } else if (amount > 1000000) {
            System.out.println("You have exceeded the limit of 1000000 rubles, you can't withdraw money");
            Main.chooseAction(this);
        }
        else{
            this.setSum(this.getSum() - amount);
            Main.chooseAction(this);
        }
    }

    public void putMoney() throws IOException {
        System.out.println("Enter the amount of money :");
        int amount = new Scanner(System.in).nextInt();
        if (amount > 1000000){
            System.out.println("Amount must not exceed 1000000");
            Main.chooseAction(this);
        }
        else this.setSum(this.getSum() + amount);
        Main.chooseAction(this);
    }
}
