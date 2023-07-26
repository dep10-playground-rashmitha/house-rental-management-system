package lk.ijse.dep10.userservice.repository;

import lk.ijse.dep10.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
