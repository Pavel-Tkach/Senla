package org.example.DataCards;

import org.example.Actions.ActionsWithAccount;
import org.example.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataCards {


    public void readCardData(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String readableBankCardData;
            while((readableBankCardData=br.readLine()) != null){
                String[] array = readableBankCardData.split(" ");
                Main.data.add(new ActionsWithAccount(array[0], array[1], Integer.parseInt(array[2])));
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
