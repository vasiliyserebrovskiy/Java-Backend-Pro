package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CompanyImpl implements Company {
    private Set<Employee> employees;
    private int capacity;

    public CompanyImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>();
    }

    // O(1)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("null");
        }
        if (capacity == employees.size()) {
            return false;
        }
        return employees.add(employee);
    }

    // O(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee victim = findEmployee(id);
        employees.remove(victim);
        return victim;
    }

    // O(n)
    @Override
    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // O(n)
    @Override
    public double totalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calcSalary();
        }
        return sum;
    }

    // O(n)
    @Override
    public double totalSales() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager sm) {
                sum += sm.getSalesValue();
            }
        }
        return sum;
    }

    // O(n)
    @Override
    public void printEmployees() {
        System.out.println("=======================");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("=======================");
    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        Predicate<Employee> predicate = e -> e.getHours() > hours;
        return findEmployeesByPredicate(predicate);
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(e -> e.calcSalary() >= minSalary && e.calcSalary() <= maxSalary);
    }

    // O(n)
    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        List<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                res.add(employee);
            }
        }
        return res.toArray(new Employee[0]);
    }
}
