package org.example.data.cards;

import org.example.field.data.bank.cards.FieldData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataCards {

    public void readCardData(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String readableBankCardData;
            while((readableBankCardData=br.readLine()) != null){
                String[] array = readableBankCardData.split(" ");
                FieldData.fieldData(array[0], array[1], Integer.parseInt(array[2]));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
