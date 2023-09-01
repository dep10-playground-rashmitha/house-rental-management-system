package lk.ijse.dep10.postservice.repository;

import lk.ijse.dep10.postservice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
    void deleteByPostId(Integer id);
}
