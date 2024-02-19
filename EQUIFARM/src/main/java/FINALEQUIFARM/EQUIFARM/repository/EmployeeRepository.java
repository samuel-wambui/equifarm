package FINALEQUIFARM.EQUIFARM.repository;

import FINALEQUIFARM.EQUIFARM.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   Optional<Employee> findByUsername(String username);
   boolean existsByUsername(String username);
   boolean existsByPfNumber(int pfNumber);
   boolean existsByEmail(String email);

}
