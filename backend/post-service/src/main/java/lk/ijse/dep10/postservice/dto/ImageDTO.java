package lk.ijse.dep10.postservice.dto;

import lk.ijse.dep10.postservice.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO implements Serializable {
    @NotBlank(message = "Image can't be empty")
    private String img;
    @NotNull(message = "Post can't be empty")
    private Post post;
}

