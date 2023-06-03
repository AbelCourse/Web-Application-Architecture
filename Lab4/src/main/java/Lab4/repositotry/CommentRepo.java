package Lab4.repositotry;

import Lab4.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments, Long> {

}
