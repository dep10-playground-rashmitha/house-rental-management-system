package lk.ijse.dep10.userservice.service;

import lk.ijse.dep10.userservice.dto.UserDTO;
public interface UserService {
    void saveUser(UserDTO user);
    void updateUser(UserDTO user);
    void deleteUser(String userName);
    UserDTO getUser(String userName,String password);

}
