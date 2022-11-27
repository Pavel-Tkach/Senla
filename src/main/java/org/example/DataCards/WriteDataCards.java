package org.example.DataCards;

import org.example.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataCards {

    public void writeCards() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Bank_card_data.txt"))){
            for (int i = 0; i < Main.data.size(); i++) {
                bufferedWriter.write(Main.data.get(i).getPassword() + " " + Main.data.get(i).getNumberCard() + " " + Main.data.get(i).getSum() + "\n");
            }
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
