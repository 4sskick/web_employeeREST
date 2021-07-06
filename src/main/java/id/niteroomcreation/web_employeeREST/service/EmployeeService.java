package id.niteroomcreation.web_employeeREST.service;

import id.niteroomcreation.web_employeeREST.exception.UserNotFound;
import id.niteroomcreation.web_employeeREST.model.Employee;
import id.niteroomcreation.web_employeeREST.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Created by monta on 06/07/21
 * please make sure to use credit when you're using people's code
 */
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee add(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee findById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(new Supplier() {
            @Override
            public Object get() {
                return new UserNotFound(String.format("user with id %s not found", id));
            }
        });
    }
}
