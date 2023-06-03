package Lab4.service.Impl;

import Lab4.domain.Comments;
import Lab4.domain.Post;
import Lab4.domain.Users;
import Lab4.domain.dto.CommentDto;
import Lab4.domain.dto.PostDto;
import Lab4.domain.dto.UserDto;
import Lab4.repositotry.UserRepo;
import Lab4.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Users save(UserDto userDto) {
        return userRepo.save(modelMapper.map(userDto, Users.class));
    }

    @Override
    public void update(int postID, UserDto userDto) {

    }

    @Override
    public List<Users> findAllUsersByPostTitle(String title) {
        return userRepo.findAllUsersByPostTitle(title);
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
        return user;
    }

    @Override
    public List<Users> getUsersWithMoreThanOnePost() {
        return userRepo.findUsersByIdWithMoreThanOnePost();
    }

    @Override
    public List<Users> getUsersWithNnumberofPosts(int n) {
        return userRepo.findUsersByIdWithMoreThanNPost(n);
    }

    @Override
    @Transactional
    public Users saveCommentByPostId(int id, int p_id,CommentDto commentDto) {
        Users user = userRepo.findById(id).get();
        Comments comment = modelMapper.map(commentDto, Comments.class);

        List<Post> posts = user.getPosts();
        Post post = posts.stream().filter(p -> p.getId() == p_id).findFirst().get();

        List comments = post.getComments();
        comments.add(comment);
        user.setPosts(posts);
        //userRepo.save(user);
        System.err.println(getById(id));
        return user;
    }

    @Override
    public Comments getCommentByPostId(int id, int pId, int cid) {
        return userRepo.getCommentByPostId(id,pId,cid);
    }

    @Override
    public List<Comments> getCommentsByPostId(int id, int pId) {
        return userRepo.getCommentsByPostId(id,pId);
    }
}
