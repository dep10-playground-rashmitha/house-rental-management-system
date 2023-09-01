package lk.ijse.dep10.postservice.service;

import lk.ijse.dep10.postservice.dto.PostDTO;

import java.util.List;

public interface PostService {
    void savePost(PostDTO post);

    void updatePost(PostDTO post);

    void deletePost(Integer id);

    PostDTO getPost(Integer id);

    List<PostDTO> findPosts(String query);
}
