package service;


import dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getAllUsers() {
        return new UserResponse();
    }
    public UserService() {
        // TODO document why this constructor is empty

    }

    public void add() {
        System.out.println("User added");
    }

    public void delete() {
        System.out.println("User deleted");
    }

    public void update() {
        System.out.println("User updated");
    }

    public void list() {
        System.out.println("User listed");
    }
}
