package Lab1.repositotry;

import Lab1.domain.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();
    public Post getById(int id);
    public void delete(int id);
    public void save(Post post);
    public void update(int postID , Post post);
    List<Post> findAllByAuthor(String author);

}
