package ua.ithillel.hillelspring.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.controller.Dto.UserDto;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final UserMapper userMapper;

    @Autowired
    public UserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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

    public ResponseEntity<List<UserDto>> toListDto(List<User> users) {
        return new ResponseEntity<>(
                users.stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    public ResponseEntity<List<User>> toList(List<UserDto> usersDto) {
        return new ResponseEntity<>(
                usersDto.stream()
                        .map(userMapper::toEntity)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
