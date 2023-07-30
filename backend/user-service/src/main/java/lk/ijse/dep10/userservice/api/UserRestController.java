package lk.ijse.dep10.userservice.api;

import lk.ijse.dep10.userservice.dto.UserDTO;
import lk.ijse.dep10.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void saveBook(@RequestBody @Validated UserDTO userDTO){
        userService.saveUser(userDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{userName}",consumes = "application/json")
    public void updateUser(@PathVariable String userName,@RequestBody @Validated UserDTO userDTO){
        userDTO.setUserName(userName);
        userService.updateUser(userDTO);
    }
    @GetMapping()
    public String getUser(@RequestParam(name = "q",required = false) String userName,@RequestParam(name = "p",required = false) String password){
        if(userName.isEmpty())throw new ResponseStatusException(HttpStatus.CONFLICT,"User Name can not be empty");
        if(password.isEmpty())throw new ResponseStatusException(HttpStatus.CONFLICT,"Password can not be empty.");
        return userService.getUser(userName,password);
    }



}
