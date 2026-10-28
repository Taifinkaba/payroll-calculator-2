package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    static void main() {
        try {
            // fileReader and bufferedReader
            FileReader fileReader = new FileReader("src/main/resources/employees.cvs");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // input
            String input = bufferedReader.readLine();

            // while loop: as long as it is not null do this
            while (input != null){

            }

            // close the reader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Could not read the employee file.");
            e.printStackTrace();
        }
    }
}
