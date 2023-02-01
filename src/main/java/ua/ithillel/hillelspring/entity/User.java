package ua.ithillel.hillelspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private int phone;
}
