package Lab4.service;

import Lab4.domain.Comments;
import Lab4.domain.Post;
import Lab4.domain.Users;
import Lab4.domain.dto.CommentDto;
import Lab4.domain.dto.PostDto;
import Lab4.domain.dto.UserDto;

import java.util.List;

public interface UserService {


    public List<Users> findAll();

    Users getById(int id);

    public void delete(int id);

    public Users save(UserDto userDto);

    public void update(int postID, UserDto userDto);

    public List<Users> findAllUsersByPostTitle(String author);

    public List<Post> getPostsByUserId(int id);

    //public List<Post> getPostsByGivenTitle(String title);

    //public void deletePostByID(int id);

    public Users savePostByUserId(int id, PostDto postDto);

    public List<Users> getUsersWithMoreThanOnePost();

    List<Users> getUsersWithNnumberofPosts(int n);

    Users saveCommentByPostId(int id, int p_id,CommentDto commentDto);

    Comments getCommentByPostId(int id, int pId, int cid);

    List<Comments> getCommentsByPostId(int id, int pId);
}
