package Lab1.controller;

import Lab1.domain.Post;
import Lab1.service.PostService;
import Lab1.domain.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping //{{uri}}?filter=Abel
    public List<Post> getAll(@RequestParam(value = "filter",required = false) String author){
        return author == null ? postService.findAll() : postService.findAllByAuthor(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void save(@RequestBody PostDto post){
        postService.save(post);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postID, @RequestBody PostDto postDto) {
        postService.update(postID,postDto);
    }

}
