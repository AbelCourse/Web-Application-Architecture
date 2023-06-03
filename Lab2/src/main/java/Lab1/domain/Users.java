package Lab1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "posts")
    List<Post> posts;

}
