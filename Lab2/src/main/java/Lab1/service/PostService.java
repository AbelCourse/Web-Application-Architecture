package Lab1.service;

import Lab1.domain.Post;
import Lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<Post> findAll();

    Post getById(int id);

    public void delete(int id);

    public void save(PostDto postDto);

    public void update(int postID, PostDto postDto);

    public List<Post> findAllByAuthor(String author);
}
