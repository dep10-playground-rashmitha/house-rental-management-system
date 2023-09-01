package lk.ijse.dep10.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {
    private Integer id;
    @NotBlank(message = "Title can't be empty")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid title")
    private String title;
    @NotBlank(message = "Description can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,}$",message = "Invalid description")
    private String description;
    @NotBlank(message = "Username can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9 ]{8,}$",message = "Invalid username")
    private String username;
//    @NotEmpty(message = "Date can't be empty")
    private Date date;
    @NotBlank(message = "Address can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "Invalid address")
    private String address;
    @NotBlank(message = "Location can't be empty")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid location")
    private String location;
    @Positive(message = "No: of rooms can't be empty or negative")
    private Integer noOfRooms;
    @Positive(message = "No: of bathrooms can't be empty or negative")
    private Integer noOfBathrooms;
    @Positive(message = "No: of floors can't be empty or negative")
    private Integer noOfFloors;
    @Positive(message = "Area can't be empty or negative")
    private BigDecimal area;
    @Positive(message = "Price can't be empty or negative")
    private BigDecimal price;
}
