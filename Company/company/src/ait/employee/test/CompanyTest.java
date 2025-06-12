package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyImpl;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private Employee[] firm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 19000, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranate", "Agraval", 80, 20000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        // TODO Homework assert exception if employee is null
        boolean flag;
        try {
            company.addEmployee(null);
            flag = true;
        } catch (RuntimeException e) {
            flag = false;
            assertEquals("null", e.getMessage());
        }
        assertFalse(flag);
        assertFalse(company.addEmployee(firm[2]));
        Employee employee = new SalesManager(5000, "Peter", "Jackson", 160, 19000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Peter", "Jackson", 160, 19000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @org.junit.jupiter.api.Test
    void removeEmployee() {
        Employee employee = company.removeEmployee(3000);
        assertEquals(3, company.quantity());
        assertEquals(firm[2], employee);
        assertNull(company.removeEmployee(3000));
    }

    @org.junit.jupiter.api.Test
    void findEmployee() {
        Employee employee = company.findEmployee(1000);
        assertEquals(firm[0], employee);
        assertNull(company.findEmployee(5000));
    }

    @org.junit.jupiter.api.Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @org.junit.jupiter.api.Test
    void totalSalary() {
        assertEquals(12280, company.totalSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void avgSalary() {
        assertEquals(12280. / 4, company.avgSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void totalSales() {
        assertEquals(39000, company.totalSales(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void printEmployees() {
        company.printEmployees();
    }

    @org.junit.jupiter.api.Test
    void findEmployeesHoursGreaterThan() {
        Employee[] actual = company.findEmployeesHoursGreaterThan(100); // {firm[2], firm[1], firm[0]};
        List<Employee> expected = List.of(actual);
        assertEquals(3, actual.length);
        assertTrue(expected.contains(firm[0]));
        assertTrue(expected.contains(firm[1]));
        assertTrue(expected.contains(firm[2]));
    }

    @org.junit.jupiter.api.Test
    void findEmployeesSalaryRange() {
        Employee[] actual = company.findEmployeesSalaryRange(2000, 2400);
        Arrays.sort(actual, (e1, e2) -> Integer.compare(e1.getId(), e2.getId()));
        Employee[] expected = {firm[1], firm[2], firm[3]};
        assertArrayEquals(expected, actual);
    }
}