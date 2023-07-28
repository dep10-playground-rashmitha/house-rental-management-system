package lk.ijse.dep10.postservice.service;

import lk.ijse.dep10.postservice.dto.ImageDTO;
import lk.ijse.dep10.postservice.dto.PostDTO;

import java.util.List;

public interface ImageService {
    void saveImage(ImageDTO image);

    void updateImage(ImageDTO image);

    void deleteImage(byte[] image);

    ImageDTO getImage(byte[] image);
}
