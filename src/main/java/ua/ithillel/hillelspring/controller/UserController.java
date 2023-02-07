package ua.ithillel.hillelspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.hillelspring.controller.dto.IntegerDto;
import ua.ithillel.hillelspring.controller.dto.UserDto;
import ua.ithillel.hillelspring.controller.mapper.UserMapper;
import ua.ithillel.hillelspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userMapper.toListDto(
                userService.getAll()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userMapper.toDto(userService.getById(id)));
    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<UserDto> getByEmailAndPhone(@PathVariable String email,
                                                      @PathVariable Integer phone) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByEmailAndPhone(email, phone)));
    }

    @GetMapping("/filter")
    public ResponseEntity<UserDto> getByFilter(@RequestParam(required = false) String name,
                                               @RequestParam String surname,
                                               @RequestParam(required = false) Integer age) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByFilter(name, surname, age)));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.save(
                                userMapper.toEntity(userDto))),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userMapper.toDto(
                userService.update(userMapper.toEntity(userDto)));
    }

    @PutMapping("/update/{name}/{surname}/{age}")
    public IntegerDto updateNameAndSurname(@PathVariable String name,
                                           @PathVariable String surname,
                                           @PathVariable Integer age) {
        return new IntegerDto(userService.updateNameAndSurname(name, surname, age));
    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}

