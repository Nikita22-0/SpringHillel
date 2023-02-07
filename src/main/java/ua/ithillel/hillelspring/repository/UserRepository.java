package ua.ithillel.hillelspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.hillelspring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?1, u.surname = ?2 where u.age = ?3")
    Integer updateNameAndSurname(String name, String  surname, Integer age);

    User getUsersByNameOrSurnameOrAge(String name, String surname, Integer age);

    User getUsersByEmailAndPhone(String email, Integer Phone);
}
