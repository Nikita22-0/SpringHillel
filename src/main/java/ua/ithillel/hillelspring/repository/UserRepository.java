package ua.ithillel.hillelspring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.service.UserService;

import java.util.List;

@Repository
public class UserRepository {

    private final UserService userService;

    @Autowired
    public UserRepository(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getById(Integer id) {
        return userService.getById(id);
    }

    public User getByEmailAndPhone(String email, Integer phone) {
        return userService.getByEmailAndPhone(email, phone);
    }

    public User getByFilter(String name, String surname, Integer age) {
        return userService.getByFilter(name, surname, age);
    }

    public User save(User user) {
        return userService.save(user);
    }

    public User update(Integer id, User user) {
        return userService.update(id, user);
    }

    public Integer delete(Integer id) {
        return userService.delete(id);
    }
}
