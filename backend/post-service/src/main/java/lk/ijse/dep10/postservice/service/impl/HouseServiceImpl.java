package lk.ijse.dep10.postservice.service.impl;

import lk.ijse.dep10.postservice.dto.HouseDTO;
import lk.ijse.dep10.postservice.entity.House;
import lk.ijse.dep10.postservice.repository.HouseRepository;
import lk.ijse.dep10.postservice.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    private final ModelMapper mapper;

    private final ImageServiceImpl imageService;

    public HouseServiceImpl(HouseRepository houseRepository, ModelMapper modelMapper, ImageServiceImpl imageService) {
        this.houseRepository = houseRepository;
        this.mapper = modelMapper;
        this.imageService = imageService;
    }


    @Override
    public void saveHouse(HouseDTO house) {
        houseRepository.save(mapper.map(house, House.class));
    }

    @Override
    public void updateHouse(HouseDTO house) {
        if(houseRepository.existsById(house.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The house id: " + house.getId() + " does not exists");
        houseRepository.save(mapper.map(house, House.class));
    }

    @Override
    public void deleteHouse(Integer id) {
        if(houseRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The house id: " + id + " does not exists");
        imageService.deleteImageByHouseId(id);
        houseRepository.deleteById(id);
    }

    @Override
    public HouseDTO getHouse(Integer id) {
        return houseRepository.findById(id)
                .map(house -> mapper.map(house, HouseDTO.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The house id: " + id + " does not exists"));
    }

    @Override
    public List<HouseDTO> findHouse(String query) {
        query = "%" + query + "%";
        return houseRepository.findHouseByAddressLikeOrLocationLike(query,query)
                .stream().map(house -> mapper.map(house,HouseDTO.class)).collect(Collectors.toList());
    }
}
