package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.models.Emploees;
import project.repositories.EmploeeRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmploeeTesting {
    @Autowired
    private EmploeeRepositories emploeeRepositories;

    @BeforeEach
    void setup() {
        emploeeRepositories.deleteAll();
    }

    @Test
    public void canSaveEmploee(){
        var emploee = Emploees.builder().firstname("FirstName").lastname("LastName").build();
        var resSave = emploeeRepositories.save(emploee);

        assertThat(resSave).isNotNull();
    }

    @Test
    public void canFineByFirstnameAndLastName(){
        String firstName = "FirstName", lastName = "LastName";

        var emploee = Emploees.builder().firstname(firstName)
                .lastname(lastName).build();
        emploeeRepositories.save(emploee);

        var resFind = emploeeRepositories.countByFirstNameAndLastName(firstName, lastName);

        assertThat(resFind).isEqualTo(1);
    }

}
