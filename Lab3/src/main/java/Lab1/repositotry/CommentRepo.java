package Lab1.repositotry;

import Lab1.domain.Comments;
import Lab1.domain.Post;
import Lab1.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comments, Long> {

}
