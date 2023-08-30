package lk.ijse.dep10.postservice.repository;

import lk.ijse.dep10.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostsByTitleLikeOrDescriptionLikeOrUserNameLikeOrAddressLikeOrLocationLike(String q1, String q2, String q3, String q4, String q5);
}