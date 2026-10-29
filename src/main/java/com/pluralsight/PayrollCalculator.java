package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    static void main() {
        Scanner myScanner = new Scanner(System.in);

        //user input for file
        System.out.println("Enter the name of the file: ");
        String inputFile = myScanner.nextLine().trim();

        // user input for create
        System.out.println("Enter the name of the payroll file for creation: ");
        String inputFileCreate = myScanner.nextLine().trim();

        // file to read from
        String folder = "src/main/resources/";

        try {
            // fileWriter and bufferedWriter
            FileReader fileReader = new FileReader(folder + inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // fileWriter and bufferedWriter
            FileWriter fileWriter = new FileWriter(folder + inputFileCreate);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // write
            bufferedWriter.write("id|name|gross pay");
            bufferedWriter.newLine();

            // input
            String input;

            // while loop: as long as it is not null do this
            while ((input =  bufferedReader.readLine()) != null){
                // skip empty lines
                if(input.trim().equals("")) continue;

                // split and seperate at each |
                String[] tokens = input.split("\\|");

                // convert each part to proper type
                int employeeId = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                double hoursWorked = Double.parseDouble(tokens[2].trim());
                double payRate = Double.parseDouble(tokens[3].trim());

                // create values
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                // write payroll info
                bufferedWriter.write(employee.getEmployeeId() + "|" + employee.getName() + "|" + String.format("%.2f", employee.getGrossPay()));
                bufferedWriter.newLine();

                // display payroll info
                System.out.printf("Id: %d, Name: %s, Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            // close the reader and writer
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Could not read the employee file.");
            e.printStackTrace();
        }
    }
}
