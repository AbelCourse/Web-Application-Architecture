package Lab4.repositotry;

import Lab4.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findAllByAuthor(String author);

}
