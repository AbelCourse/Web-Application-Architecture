package Lab1.repositotry;

import Lab1.domain.Comments;
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

    @Query("select u from Users u where size(u.posts) > :n")
    List<Users> findUsersByIdWithMoreThanNPost(int n);

    @Query("select u from Users u join Post p where p.title like :title")
    List<Users> findAllUsersByPostTitle(String title);

    @Query("SELECT c FROM Users u JOIN u.posts p JOIN p.comments c WHERE u.id = :u_id AND p.id = :p_id AND c.id = :c_id")
    Comments getCommentByPostId(int u_id, int p_id, int c_id);

    @Query("SELECT c FROM Users u JOIN u.posts p JOIN p.comments c WHERE u.id = :id AND p.id = :pId")
    List<Comments> getCommentsByPostId(int id, int pId);
}
