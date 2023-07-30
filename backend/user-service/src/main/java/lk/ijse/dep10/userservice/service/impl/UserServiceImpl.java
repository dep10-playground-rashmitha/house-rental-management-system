package lk.ijse.dep10.userservice.service.impl;

import lk.ijse.dep10.userservice.dto.UserDTO;
import lk.ijse.dep10.userservice.entity.User;
import lk.ijse.dep10.userservice.repository.UserRepository;
import lk.ijse.dep10.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveUser(UserDTO user) {
        if(userRepository.existsById(user.getUserName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The User Name Already Exist.");
        }else if(userRepository.existsByTelNo(user.getTelNo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"The Telephone Number already exist.");
        }else if(userRepository.existsByEmail(user.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exist.");
        }

        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public void updateUser(UserDTO user) {
        if(!userRepository.existsById(user.getUserName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"The User Name can not find.");

        User searchUserByTelNo=userRepository.findByTelNo(user.getTelNo());
        if(searchUserByTelNo!=null && !(searchUserByTelNo.getUserName().equals(user.getUserName())))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Telephone Number Already Exist.");

        User searchByEmail=userRepository.findByEmail(user.getEmail());
        if(searchByEmail!=null && !(searchByEmail.getUserName().equals(user.getUserName())))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email is already exists.");

        userRepository.save(modelMapper.map(user,User.class));
    }

    @Override
    public void deleteUser(String userName) {

    }

    @Override
    public String getUser(String userName,String password) {
        if(!userRepository.existsById(userName))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"No User Name matched.");

        Optional<User> userRepositoryById = userRepository.findById(userName);
        if(!userRepositoryById.get().getPassword().equals(password))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Password is incorrect");

        return "Successfully Log In.";
    }
}
