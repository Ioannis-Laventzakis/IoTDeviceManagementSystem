package service;

import dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetAllUsers() {
        UserResponse response = userService.getAllUsers();
        assertNotNull(response);
    }

    @Test
    void testAdd() {
        userService.add();
    }

    @Test
    void testDelete() {
        userService.delete();
    }

    @Test
    void testUpdate() {
        userService.update();
    }

    @Test
    void testList() {
        userService.list();
    }
}