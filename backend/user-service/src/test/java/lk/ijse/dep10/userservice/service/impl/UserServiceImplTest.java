package lk.ijse.dep10.userservice.service.impl;

import lk.ijse.dep10.userservice.dto.UserDTO;
import lk.ijse.dep10.userservice.entity.User;
import lk.ijse.dep10.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceImplTest {

    @Autowired
    private  UserRepository userRepository;
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        userService=new UserServiceImpl(userRepository,modelMapper);
    }

    @Test
    void saveUser() {
        UserDTO user=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Kamal","Rash@12345");
        userService.saveUser(user);
        assertTrue(userRepository.existsById(user.getUserName()));
    }
    @Test
    void saveUserInvalid() {
        UserDTO user1=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Kamal","Rash@12345");
        UserDTO user2=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Kamal","Rash@12345");
        userService.saveUser(user1);
        assertThrows(ResponseStatusException.class,()->userService.saveUser(user2));

    }
    @Test
    void saveUserSamePhoneNumber() {
        UserDTO user1=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Saman","Rash@12345");
        UserDTO user2=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Kamal","Rash@12345");
        userService.saveUser(user1);
        assertThrows(ResponseStatusException.class,()->userService.saveUser(user2));

    }
    @Test
    void saveUserSameEmail() {
        UserDTO user1=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Saman","Rash@12345");
        UserDTO user2=new UserDTO("kamal","saman","Galle","077-1234569",
                "ra@gmail.com","Saman","Rash@12345");
        userService.saveUser(user1);
        assertThrows(ResponseStatusException.class,()->userService.saveUser(user2));

    }

    @Test
    void updateUser() {
        UserDTO user1=new UserDTO("kamal","saman","Galle","077-1234567",
                "ra@gmail.com","Saman","Rash@12345");
        userService.saveUser(user1);
        UserDTO user2=new UserDTO("kamal","Nishantha","Matara","077-1234567",
                "ra@gmail.com","Saman","Rash@12345");
        userService.updateUser(user2);
        User user = userRepository.findById(user1.getUserName()).get();
        System.out.println(user1);
        System.out.println(user2);
        assertTrue(!(user.getAddress().equals(user1.getAddress())));
    }
}