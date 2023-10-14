package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.assertj.core.api.Assertions.assertThat;

import project.models.Emploees;
import project.repositories.EmploeeRepositories;

@SpringBootTest
@AutoConfigureMockMvc
public class EmploeeCanNotAddTesting {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmploeeRepositories emploeeRepositories;

    @BeforeEach
    void setup() {
        emploeeRepositories.deleteAll();
    }

    @Test
    public void testMethod_amount() throws Exception{
        String firstName = "FirstName", lastName = "LastName";

        var emploee = Emploees.builder().firstname(firstName).lastname(lastName).build();

        mvc.perform(post("/emploee/add-emploee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(emploee))
            ).andDo(print());

        var resFind = emploeeRepositories.countByFirstNameAndLastName(firstName, lastName);

        assertThat(resFind).isEqualTo(1);
        System.out.println("resFind:" + resFind);

    }


}
