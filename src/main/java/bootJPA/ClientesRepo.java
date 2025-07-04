package bootJPA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepo extends JpaRepository<Clientes, Integer> {
List<Clientes> findByDniOrderByDniAsc(Integer dni);
@Query("""
	    SELECT DISTINCT c FROM Clientes c
	    JOIN c.habitaciones h
	    JOIN h.hoteles ho
	    JOIN ho.empleados e
	    WHERE e.dni = :dniEmpleado
	    Order by c.dni DESC
	""")
	List<Clientes> buscarClientesPorDniDeEmpleado(@Param("dniEmpleado") String dniEmpleado);
List<Clientes> findByDniAndHabitaciones_Hoteles_EmpleadosDniOrderByDniDesc(Integer dniCliente, String dniEmpleado);
List<Clientes> findAll();
}