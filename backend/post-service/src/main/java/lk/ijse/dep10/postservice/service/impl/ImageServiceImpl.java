package lk.ijse.dep10.postservice.service.impl;

import lk.ijse.dep10.postservice.dto.ImageDTO;
import lk.ijse.dep10.postservice.entity.Image;
import lk.ijse.dep10.postservice.repository.ImageRepository;
import lk.ijse.dep10.postservice.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    private ModelMapper mapper;

    public ImageServiceImpl(ImageRepository imageRepository, ModelMapper mapper) {
        this.imageRepository = imageRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveImage(ImageDTO image) {
        if(imageRepository.existsById(image.getImage()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This image already exists in the system");
        imageRepository.save(mapper.map(image, Image.class));
    }

    @Override
    public void updateImage(ImageDTO image) {
        if(imageRepository.existsById(image.getImage()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This image already exists in the system");
        imageRepository.save(mapper.map(image, Image.class));
    }

    @Override
    public void deleteImage(byte[] image) {
        if(imageRepository.existsById(image))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This image does not exists");
        imageRepository.deleteById(image);
    }

    @Override
    public ImageDTO getImage(byte[] image) {
        return imageRepository.findById(image)
                .map(img -> mapper.map(img, ImageDTO.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The image does not exists"));
    }

    @Override
    public void deleteImageByHouseId(Integer houseId) {
        imageRepository.deleteByHouse_Id(houseId);
    }

}
