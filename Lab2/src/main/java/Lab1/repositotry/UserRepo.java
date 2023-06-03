package Lab1.repositotry;

import Lab1.domain.Post;
import Lab1.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Integer> {

    @Query("select u.posts from Users u where u.id= :id")
    List<Post> findPostsById(@Param("id") int id);

    @Query("select u from Users u where size(u.posts) > 1")
    List<Users> findUsersByIdWithMoreThanOnePost();


//    void deletePostByPostID(int id);
}
