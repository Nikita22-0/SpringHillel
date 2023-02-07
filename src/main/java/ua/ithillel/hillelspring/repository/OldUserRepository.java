package ua.ithillel.hillelspring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelspring.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OldUserRepository {

    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void addUser() {
        users.add(new User(0, "Bob", "Jackson", 32, "bob@gmail.com", 504561238));
        users.add(new User(1, "John", "Smith", 20, "john@gmail.com", 631264598));
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    public User getByEmailAndPhone(String email, Integer phone) {
        for (User user : users) {
            if (email.equals(user.getEmail()) && phone.equals(user.getPhone())) {
                return user;
            }
        }
        return null;
    }

    public User getByFilter(String name, String surname, Integer age) {
        for (User user : users) {
            if (surname.equals(user.getSurname()) || name.equals(user.getName()) || age.equals(user.getAge())) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size() - 1);
        return user;
    }

    public User update(Integer id, User user) {
        User oldUser = users.get(id);
        oldUser.setId(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        return users.get(id);
    }

    public Integer delete(int id) {
        users.remove(id);
        return id;
    }
}
