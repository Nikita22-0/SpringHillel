package ua.ithillel.hillelspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getByEmailAndPhone(String email, Integer phone) {
        return userRepository.getUsersByEmailAndPhone(email, phone);
    }

    public User getByFilter(String name, String surname, Integer age) {
        return userRepository.getUsersByNameOrSurnameOrAge(name, surname, age);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer updateNameAndSurname(String name, String surname, Integer age) {
        return userRepository.updateNameAndSurname(name, surname, age);
    }

    public Integer delete(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
