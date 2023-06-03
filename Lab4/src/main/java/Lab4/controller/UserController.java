package Lab4.controller;


import Lab4.advice.annotation.ExecutionTime;
import Lab4.domain.Comments;
import Lab4.domain.Post;
import Lab4.domain.Users;
import Lab4.domain.dto.CommentDto;
import Lab4.domain.dto.PostDto;
import Lab4.domain.dto.UserDto;
import Lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    //FINDS ALL USERS AND ALSO FINDS USERS WITH A SPECIFIC POST TITLES
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    //{{uri}}?filter=Abel
    //public List<User> getAllUsers(@RequestParam(value = "filter",required = false) String author){
    public List<Users> getAllUsers(@RequestParam(value = "filter",required = false) String title){
        return title == null ?
                userService.findAll() :
                userService.findAllUsersByPostTitle(title);
    }


    @ExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id){
        return userService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/exception")
    public Exception exception() {
        return new Exception("Exception");
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> getPostByUserId(@PathVariable int id){
        return userService.getPostsByUserId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/moreThanOnePost")
    public List<Users> getUsersWithMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/moreposts/{numofposts}")
    public List<Users> getPosts(@PathVariable int numofposts){
        return userService.getUsersWithNnumberofPosts( numofposts);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/posts")
    public Users savePostByUserId(@PathVariable int id,@RequestBody PostDto postDto){
        return userService.savePostByUserId(id, postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts/{p_id}/comments")
    public List<Comments> getCommentsByPostId(@PathVariable int id, @PathVariable int p_id){
        return userService.getCommentsByPostId(id, p_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts/{p_id}/comments/{c_id}")
    public Comments getCommentByPostId(@PathVariable int id, @PathVariable int p_id, @PathVariable int c_id){
        return userService.getCommentByPostId(id, p_id, c_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/posts/{p_id}/comments")
    public Users saveCommentByPostId(@PathVariable int id,@PathVariable int p_id,@RequestBody CommentDto commentDto){
        return userService.saveCommentByPostId(id, p_id, commentDto);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{id}posts/{postID}")
//    public void deletePostByID(@PathVariable int id, @PathVariable int postID){
//        userService.deletePostByID(postID);
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping
    public Users saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }


}