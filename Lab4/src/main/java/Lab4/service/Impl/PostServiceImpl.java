package Lab4.service.Impl;

import Lab4.domain.Post;
import Lab4.repositotry.PostRepo;
import Lab4.service.PostService;
import Lab4.domain.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.getById(id);
    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void update(int postID, PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public List<Post> findAllByAuthor(String author) {
        return postRepo.findAllByAuthor(author);
    }
}
