package Lab1.controller;


import Lab1.domain.Post;
import Lab1.domain.Users;
import Lab1.domain.dto.PostDto;
import Lab1.domain.dto.UserDto;
import Lab1.service.PostService;
import Lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping //{{uri}}?filter=Abel
    //public List<User> getAllUsers(@RequestParam(value = "filter",required = false) String author){
    public List<Users> a(){
        return userService.findAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id){
        return userService.getById(id);
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
    @GetMapping("/moreposts")
    public List<Users> getUsersWithMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost();
    }



    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/posts")
    public Users savePostByUserId(@PathVariable int id,@RequestBody PostDto postDto){
        return userService.savePostByUserId(id, postDto);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{id}posts/{postID}")
//    public void deletePostByID(@PathVariable int id, @PathVariable int postID){
//        userService.deletePostByID(postID);
//    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void saveUser(@RequestBody UserDto userDto){
        userService.save(userDto);
    }


}