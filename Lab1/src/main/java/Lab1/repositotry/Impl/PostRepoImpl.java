package Lab1.repositotry.Impl;

import Lab1.domain.Post;
import Lab1.repositotry.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static int postID = 1;
    static {
        posts = new ArrayList<>();

        Post p1 = new Post(postID,"First Post","iPhone13","Abel");
        Post p2 = new Post(postID+1,"Second Post","Samsung","Bela");
        Post p3 = new Post(postID+2,"Third Post","Google","Me");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        Optional<Post> post = posts.stream().filter(p -> p.getId() == id).findFirst();
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        var product =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(product);
    }

    @Override
    public void save(Post post) {
        post.setId(postID + posts.stream().count());
        posts.add(post);

    }

    @Override
    public void update(int postID, Post post) {
        Post post1 = getById(postID);
        post1.setAuthor(post.getAuthor());
        post1.setContent(post.getContent());
        post1.setTitle(post.getTitle());
    }

    @Override
    public List<Post> findAllByAuthor(String author) {
        return posts.stream().filter(l -> l.getAuthor().equalsIgnoreCase(author)).toList();
    }

}
