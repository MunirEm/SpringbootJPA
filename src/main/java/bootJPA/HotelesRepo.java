package bootJPA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelesRepo extends JpaRepository<Hoteles, Integer> {
List<Hoteles> findByCiudad(String ciudad);
List<Hoteles>findByPaisAndEstrellasGreaterThan(String pais, Integer estrellas);
@Query("SELECT h FROM Hoteles h WHERE h.pais = 'SPAIN' AND h.estrellas > 3")
List<Hoteles> findHotelesEspanaTresEstrellas();
}