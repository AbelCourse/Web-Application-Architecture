package Lab1.service;

import Lab1.domain.Post;
import Lab1.domain.Users;
import Lab1.domain.dto.PostDto;
import Lab1.domain.dto.UserDto;

import java.util.List;

public interface UserService {


    public List<Users> findAll();

    Users getById(int id);

    public void delete(int id);

    public void save(UserDto userDto);

    public void update(int postID, UserDto userDto);

    public List<Users> findAllByAuthor(String author);

    public List<Post> getPostsByUserId(int id);

    //public void deletePostByID(int id);

    public Users savePostByUserId(int id, PostDto postDto);

    public List<Users> getUsersWithMoreThanOnePost();

}
