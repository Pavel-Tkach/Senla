package org.example;

public abstract class ATM {

    private String password;
    private String numberCard;

    public ATM(String password, String numberCard) {
        this.password = password;
        this.numberCard = numberCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getPassword() {
        return password;
    }
}
