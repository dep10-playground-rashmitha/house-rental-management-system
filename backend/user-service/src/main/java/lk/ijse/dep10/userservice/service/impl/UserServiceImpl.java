package lk.ijse.dep10.userservice.service.impl;

import lk.ijse.dep10.userservice.dto.UserDTO;
import lk.ijse.dep10.userservice.repository.UserRepository;
import lk.ijse.dep10.userservice.service.UserService;
import org.modelmapper.ModelMapper;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveUser(UserDTO user) {

    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void deleteUser(String userName) {

    }

    @Override
    public void getUser(String userName) {

    }
}
