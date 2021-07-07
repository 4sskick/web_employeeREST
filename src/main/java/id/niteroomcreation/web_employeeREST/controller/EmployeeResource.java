package id.niteroomcreation.web_employeeREST.controller;


import id.niteroomcreation.web_employeeREST.model.Employee;
import id.niteroomcreation.web_employeeREST.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    public static final String TAG = EmployeeResource.class.getSimpleName();

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee empl) {
        Employee employee = employeeService.add(empl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee empl) {
        Employee employee = employeeService.update(empl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
