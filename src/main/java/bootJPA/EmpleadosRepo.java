package bootJPA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleadosRepo extends JpaRepository<Empleados, String> {
List<Empleados> findByDniOrderByDniAsc(String dni);
List<Empleados> findByDni(String dni);
List<Empleados> findByCategoriaAndSalarioLessThanEqualOrderByCategoriaDesc(int categoria, Double salario);

@Query("SELECT COUNT(e) FROM Empleados e WHERE e.categoria = ?1 AND e.salario BETWEEN ?2 AND ?3")
Long countByCategoriaAndSalarioBetween(int categoria, Double salarioMin, Double salarioMax);
}