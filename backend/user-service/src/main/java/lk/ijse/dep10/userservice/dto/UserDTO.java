package lk.ijse.dep10.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "First Name can not be empty.")
    @Pattern(regexp = "^[A-Za-z ]{3,}$",message = "Invalid First Name")
    private String firstName;
    @NotBlank(message = "Last Name can not be empty.")
    @Pattern(regexp = "^[A-Za-z ]{3,}$",message = "Invalid Last Name")
    private String lastName;
    @NotBlank(message = "Address can not be empty.")
    @Pattern(regexp = "^[A-Za-z0-9 ]{3,}$",message = "Include correct address.")
    private String address;
    @NotBlank(message = "Tel Number can not be empty.")
    @Pattern(regexp = "^\\d{3}-\\d{7}$",message = "Invalid Telephone Number.")
    private String telNo;
    @NotBlank(message = "User Name can not be empty.")
    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{4,19}$",message = "Invalid User Name.")
    private String userName;
    @NotBlank(message = "Password can not be empty.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[A-Za-z0-9])(?=.{8,})",message = "Password should include more than 8" +
            "characters and should include Uppercase,Lowercase,Digit and one character.")
    private String password;

}
