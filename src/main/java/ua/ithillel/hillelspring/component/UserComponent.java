package ua.ithillel.hillelspring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.repository.UserRepository;

import java.util.List;

@Component
public class UserComponent {
//    private final UserRepository userRepository;

//    @Autowired
//    public UserComponent(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> getAll() {
//        return userRepository.getAll();
//    }
//
//    public User getById(Integer id){
//        return userRepository.getById(id);
//    }
//
//    public User getByEmailAndPhone(String email, Integer phone){
//        return userRepository.getByEmailAndPhone(email,phone);
//    }
//
//    public User getByFilter(String name, String surname, Integer age){
//        return userRepository.getByFilter(name, surname, age);
//    }
//
//    public User save(User user){
//        return userRepository.save(user);
//    }
//
//    public User update(Integer id, User user){
//        return userRepository.update(id, user);
//    }
//
//    public Integer delete(Integer id){
//        return userRepository.delete(id);
//    }
}
