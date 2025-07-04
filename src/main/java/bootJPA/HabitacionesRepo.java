package bootJPA;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HabitacionesRepo extends JpaRepository<Habitaciones, Integer> {
List<Habitaciones> findByNumerohOrderByNumerohAsc(Integer numeroh);

List<Habitaciones> findByPrecionocheBetween(int min, int max);

}