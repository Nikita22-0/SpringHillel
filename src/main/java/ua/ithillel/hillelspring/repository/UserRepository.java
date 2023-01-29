package ua.ithillel.hillelspring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.service.UserService;

import java.util.List;

@Controller
public class UserRepository {

    @Autowired
    private UserService userService;

    public List<User> getAll(){
        return userService.getAll();
    }
}
