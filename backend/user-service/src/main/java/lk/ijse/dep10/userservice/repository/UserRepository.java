package lk.ijse.dep10.userservice.repository;

import lk.ijse.dep10.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByTelNo(String telNo);
    boolean existsByEmail(String email);
    User findByTelNo(String telNo);
    User findByEmail(String email);
}
