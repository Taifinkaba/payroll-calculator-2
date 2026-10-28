package com.pluralsight;

public class PayrollCalculator {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    // employee values
    public Employee(int employeeId, String name, double hoursWorked, double payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }
}
