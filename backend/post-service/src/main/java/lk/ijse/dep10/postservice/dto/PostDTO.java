package lk.ijse.dep10.postservice.dto;

import lk.ijse.dep10.postservice.entity.House;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {
    @NotBlank(message = "Post id can't be empty")
    private Integer id;
    @NotBlank(message = "Title can't be empty")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid title")
    private String title;
    @NotBlank(message = "Description can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9 ]{150,}$",message = "Invalid description")
    private String description;
    @NotBlank(message = "Username can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9 ]{8,}$",message = "Invalid username")
    private String username;
    @NotBlank(message = "Date can't be empty")
    private Date date;
    @NotBlank(message = "House can't be empty")
    private House house;
}
