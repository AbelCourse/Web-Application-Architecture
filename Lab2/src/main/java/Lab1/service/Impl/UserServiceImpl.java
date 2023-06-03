package Lab1.service.Impl;

import Lab1.domain.Post;
import Lab1.domain.Users;
import Lab1.domain.dto.PostDto;
import Lab1.domain.dto.UserDto;
import Lab1.repositotry.PostRepo;
import Lab1.repositotry.UserRepo;
import Lab1.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Users> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Users getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        userRepo.delete(getById(id));
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, Users.class));
    }

    @Override
    public void update(int postID, UserDto userDto) {

    }

    @Override
    public List<Users> findAllByAuthor(String author) {
        return null;
    }

    @Override
    public List<Post> getPostsByUserId(int id) {
        return userRepo.findPostsById(id);
    }

//    @Override
//    public void deletePostByID(int id) {
//        userRepo.deletePostByPostID(id);
//    }

    @Override
    @Transactional
    public Users savePostByUserId(int id, PostDto postDto) {
        Users user = userRepo.findById(id).get();
        Post post = modelMapper.map(postDto, Post.class);
        List posts = user.getPosts();
        posts.add(post);
        user.setPosts(posts);
        //userRepo.save(user);
        System.err.println(getById(id));
        return user;
    }

    @Override
    public List<Users> getUsersWithMoreThanOnePost() {
        return userRepo.findUsersByIdWithMoreThanOnePost();
    }
}
