package Lab1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue
    long id;
    String name;
}
