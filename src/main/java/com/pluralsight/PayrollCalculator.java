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

                // display payroll info
                System.out.printf("Id: %d, Name: %s, Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            // close the reader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Could not read the employee file.");
            e.printStackTrace();
        }
    }
}
