package sky.pro.Employee.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<Employee> createEmployee(String fullName, int salary, int department) {

        if (!StringUtils.isAlpha(fullName)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.createEmployee(fullName, salary, department));
    }

    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("all")
    public List<Employee> getAllEmployees(int departmentId) {
        return employeeService.getAllEmployees(departmentId);

    }

    @GetMapping("all-grouped")
    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment() {
        return employeeService.getAllEmployeesGroupByDepartment();
    }
}