package lk.ijse.dep10.userservice.service.impl;

import lk.ijse.dep10.userservice.dto.UserDTO;
import lk.ijse.dep10.userservice.entity.User;
import lk.ijse.dep10.userservice.repository.UserRepository;
import lk.ijse.dep10.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveUser(UserDTO user) {
        if(userRepository.existsById(user.getUserName())&&userRepository.existsByTelNo(user.getTelNo()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"The User Name Already Exist.");
        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public void updateUser(UserDTO user) {
        if(!userRepository.existsById(user.getUserName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"The User Name can not find.");
        User searchUser=userRepository.findByTelNo(user.getTelNo());
        if(searchUser!=null && !(searchUser.getUserName().equals(user.getUserName()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Telephone Number Already Exist.");
        }
        userRepository.save(modelMapper.map(user,User.class));
    }

    @Override
    public void deleteUser(String userName) {

    }

    @Override
    public UserDTO getUser(String userName,String password) {
        if(!userRepository.existsById(userName)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"No User Name");
        }
    }
}
