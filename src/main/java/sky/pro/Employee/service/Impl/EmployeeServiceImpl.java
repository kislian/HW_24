package sky.pro.Employee.service.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.EmployeeService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    //private final List<Employee> employeesList=new ArrayList<>();
    @PostConstruct
    public void init() {
        employees.put("employee1", new Employee("employee1", 50_000, 1));
        employees.put("employee2", new Employee("employee2", 100_000, 1));
        employees.put("employee3", new Employee("employee3", 150_000, 1));
        employees.put("employee4", new Employee("employee4", 60_000, 2));
        employees.put("employee5", new Employee("employee5", 120_000, 2));
        employees.put("employee6", new Employee("employee6", 70_000, 3));
        employees.put("employee7", new Employee("employee7", 110_000, 3));
        employees.put("employee8", new Employee("employee8", 40_000, 4));
        employees.put("employee9", new Employee("employee9", 110_000, 4));
        employees.put("employee10", new Employee("employee10", 80_000, 5));
        employees.put("employee11", new Employee("employee11", 100_000, 5));
        employees.put("employee12", new Employee("employee12", 130_000, 5));

    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployees(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee createEmployee(String fullName, int salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
        return employees.put(employee.getFullName(), employee);
    }

}
