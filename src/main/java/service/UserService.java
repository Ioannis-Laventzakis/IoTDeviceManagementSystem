package service;


import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService() {
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
