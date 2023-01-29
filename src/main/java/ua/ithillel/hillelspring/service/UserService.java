package ua.ithillel.hillelspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.controller.UserController;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserController userController;

    public List<User> getAll(){
        return userController.getAll();
    }
}
