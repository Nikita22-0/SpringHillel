package ua.ithillel.hillelspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.controller.UserController;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;

@Service
public class UserService {
    private final UserController userController;

    @Autowired
    public UserService(UserController userController) {
        this.userController = userController;
    }

    public List<User> getAll() {
        return userController.getAll();
    }

    public User getById(Integer id) {
        return userController.getById(id);
    }

    public User getByEmailAndPhone(String email, Integer phone) {
        return  userController.getByEmailAndPhone(email, phone);
    }

    public User getByFilter(String name, String surname, Integer age) {
        return userController.getByFilter(name, surname, age);
    }

    public User save(User user) {
        return userController.save(user);
    }

    public User update(Integer id, User user) {
        return userController.update(id, user);
    }

    public Integer delete(Integer id) {
        return userController.delete(id);
    }
}
