package lk.ijse.dep10.postservice.repository;

import lk.ijse.dep10.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
