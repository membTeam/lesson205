package project.repositories;

import org.springframework.data.repository.CrudRepository;
import project.models.Emploees;

public interface EmploeeRepositories extends CrudRepository<Emploees, String> {

}
