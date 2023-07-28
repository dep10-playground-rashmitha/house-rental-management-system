package lk.ijse.dep10.postservice.repository;

import lk.ijse.dep10.postservice.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Integer> {
    List<House> findHouseByAddressLikeOrLocationLike(String q1, String q2);
}
