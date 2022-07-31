package com.example.lists;

public interface ListService {
    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;
    Employee add(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;
    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;
}
