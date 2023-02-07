package ua.ithillel.hillelspring.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.controller.dto.UserDto;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

//    Создаётся цикл и невозможно запустить приложение
//    private final UserMapper userMapper;
//
//    @Autowired
//    public UserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }


    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getEmail(),
                userDto.getPhone()
        );
    }

    public List<UserDto> toListDto(List<User> users) {
        UserMapper userMapper = new UserMapper();
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

    }

    public List<User> toList(List<UserDto> usersDto) {
        UserMapper userMapper = new UserMapper();
        return usersDto.stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());
    }
}
