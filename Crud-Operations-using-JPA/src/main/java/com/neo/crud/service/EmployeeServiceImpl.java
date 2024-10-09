package com.neo.crud.service;

import com.neo.crud.exception.EmployeeNotFoundException;
import com.neo.crud.model.Employee;
import com.neo.crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : " +id+"  for Update"));
        emp.setId(employee.getId());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setDepartment(employee.getDepartment());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmoloyee(Long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with " + id + " for Deletion"));
        employeeRepository.deleteById(id);
    }


}
