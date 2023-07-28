package lk.ijse.dep10.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseDTO implements Serializable {
    @NotBlank(message = "House id can't be empty")
    private Integer id;
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
