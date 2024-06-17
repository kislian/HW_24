package sky.pro.Employee.service;

import sky.pro.Employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee getEmployeeWithMinSalary(int department);
    Employee getEmployeeWithMaxSalary(int department);
    List<Employee> getAllEmployees(int department);
    Map<Integer,List<Employee>> getAllEmployeesGroupByDepartment();
    Employee createEmployee(String fullName, int salary, int department);
}