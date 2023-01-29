package ua.ithillel.hillelspring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.repository.UserRepository;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;

@Component
public class UserComponent {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
}
