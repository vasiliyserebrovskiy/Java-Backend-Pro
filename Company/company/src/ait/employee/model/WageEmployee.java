package ait.employee.model;

public class WageEmployee extends Employee {
    private double wage;

    public WageEmployee(int id, String firstName, String lastName, double hours, double wage) {
        super(id, firstName, lastName, hours);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double calcSalary() {
        double salary = wage * hours;
        if (salary < hours * minWage) {
            salary = hours * minWage;
        }
        return salary;
    }

}
