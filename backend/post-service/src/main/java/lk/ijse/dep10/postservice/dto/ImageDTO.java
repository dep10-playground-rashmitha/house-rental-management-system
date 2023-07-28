package lk.ijse.dep10.postservice.dto;

import lk.ijse.dep10.postservice.entity.House;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO implements Serializable {
    @NotBlank(message = "Image can't be empty")
    private byte[] image;
    @NotBlank(message = "House can't be empty")
    private House house;
}
