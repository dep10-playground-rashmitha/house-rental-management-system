package lk.ijse.dep10.postservice.service;

import lk.ijse.dep10.postservice.dto.HouseDTO;
import lk.ijse.dep10.postservice.dto.PostDTO;

import java.util.List;

public interface HouseService {
    void saveHouse(HouseDTO house);

    void updateHouse(HouseDTO house);

    void deleteHouse(Integer id);

    HouseDTO getHouse(Integer id);

    List<HouseDTO> findHouse(String query);
}
