package FINALEQUIFARM.EQUIFARM.service.impl;

import FINALEQUIFARM.EQUIFARM.exemption.ExemptionNotFound;
import FINALEQUIFARM.EQUIFARM.model.Employee;
import FINALEQUIFARM.EQUIFARM.repository.EmployeeRepository;
import FINALEQUIFARM.EQUIFARM.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
       if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ExemptionNotFound("Employee", "Id", id);
        }
       // return employeeRepository.findAllById(id).orElseThrow(()->new ExemptionNotFound("Employee", "Id", id))
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ExemptionNotFound("Employee", "Id",id));
        existingEmployee.setUsername(employee.getUsername());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPfNumber(employee.getPfNumber());
        existingEmployee.setPassword(employee.getPassword());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
                ()-> new ExemptionNotFound("Employee","employee",id));
        employeeRepository.deleteById(id);
    }
}
