package com.example.lists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {
    private static final int size = 10;
    List<Employee> employees = new ArrayList<>(size);

    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Уже добавлен");
        }
        if (employees.size() > size) {
            throw new EmployeeStorageIsFullException("Достаточно сотрудников");
        } else {
            employees.add(employee);
            return employee;
        }

    }

    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Не найден");

        } else {
            employees.remove(employee);
            return employee;
        }
    }
}