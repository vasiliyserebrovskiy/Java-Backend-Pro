package ait.employee.model;

public abstract class Employee {
    protected static double minWage = 13;
    protected final int id;
    protected String firstName;
    protected String lastName;
    protected double hours;

    public Employee(int id, String firstName, String lastName, double hours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
    }

    public static double getMinWage() {
        return minWage;
    }

    public static void setMinWage(double minWage) {
        Employee.minWage = minWage;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHours() {
        return hours;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public abstract double calcSalary();

    @Override
    public final boolean equals(Object object) {
        if (!(object instanceof Employee employee)) return false;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hours=" + hours +
                ", salary=" + calcSalary();
    }
}
