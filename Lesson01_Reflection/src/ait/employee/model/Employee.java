package ait.employee.model;

import ait.utils.Id;
import ait.utils.Index;
import ait.utils.Table;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
@Table(name = "employees")
public class Employee {
    @Id
    @Index(unique = true)
    private int id;
    @Index()
    private String name;
    @Index()
    private int salary;
    private LocalDate birthDate;
    @Index(unique = true)
    private String email;

    public Employee(int id, String name, int salary, LocalDate birthDate, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthDate = birthDate;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
