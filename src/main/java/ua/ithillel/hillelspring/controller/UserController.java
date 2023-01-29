package ua.ithillel.hillelspring.controller;

import org.springframework.stereotype.Repository;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;

@Repository
public class UserController {
    public List<User> getAll(){
        return List.of(
                new User("Bob", "Jackson", 32, "bob@gmail.com"),
                new User("John", "Smith", 20, "john@gmail.com")
        );
    }
}
