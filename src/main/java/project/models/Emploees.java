package project.models;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import project.config.GeneratedId;

@Data
@Builder
public class Emploees implements GeneratedId {
    @Id
    private String id;
    private String firstname;
    private String lastname;
}
