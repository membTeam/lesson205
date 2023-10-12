package project.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import project.models.Emploees;

public interface EmploeeRepositories extends CrudRepository<Emploees, String> {
    @Query("select count(*) from emploees where firstname=:firstname and lastname=:lastname")
    int countByFirstNameAndLastName(@Param("firstname") String firstname,
                                    @Param("lastname") String lastname);
}
