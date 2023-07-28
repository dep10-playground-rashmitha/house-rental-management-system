package lk.ijse.dep10.postservice.service.impl;

import lk.ijse.dep10.postservice.dto.PostDTO;
import lk.ijse.dep10.postservice.entity.Post;
import lk.ijse.dep10.postservice.repository.PostRepository;
import lk.ijse.dep10.postservice.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    private final HouseServiceImpl houseService;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, HouseServiceImpl houseService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.houseService = houseService;
    }

    @Override
    public void savePost(PostDTO post) {
        postRepository.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void updatePost(PostDTO post) {
        if (postRepository.existsById(post.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post id: " + post.getId() + " does not exists");
        postRepository.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void deletePost(Integer id) {
        if(postRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The    post id: " + id + " does not exists");
        PostDTO post = getPost(id);
        houseService.deleteHouse(post.getHouse().getId());
        postRepository.deleteById(id);
    }

    @Override
    public PostDTO getPost(Integer id) {
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDTO.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The post id: " + id + " does not exists"));
    }

    @Override
    public List<PostDTO> findPosts(String query) {
        query = "%" + query + "%";
        return postRepository.findPostsByTitleLikeOrDescriptionLikeOrUserNameLike(query,query,query)
                .stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }
}
