package petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
