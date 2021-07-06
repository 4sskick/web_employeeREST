package id.niteroomcreation.web_employeeREST.repo;

import id.niteroomcreation.web_employeeREST.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by monta on 06/07/21
 * please make sure to use credit when you're using people's code
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
