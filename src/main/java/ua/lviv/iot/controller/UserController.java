package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.user.CreateUpdateUserDto;
import ua.lviv.iot.dto.user.UserDto;
import ua.lviv.iot.mappers.UserMapper;
import ua.lviv.iot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.UserMapper.mapUserToUserDto;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    UserDto createUser(final @Valid @RequestBody CreateUpdateUserDto createUpdateUserDto) {
        return mapUserToUserDto(userService.createUser(createUpdateUserDto));
    }

    @GetMapping
    List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserDto getUserById(final @PathVariable("id") Integer id) {
        return mapUserToUserDto(userService.getUserById(id));
    }

    @PutMapping
    UserDto updateUser(final @Valid @RequestBody CreateUpdateUserDto createUpdateUserDto) {
        return mapUserToUserDto(userService.updateUser(createUpdateUserDto));
    }

    @DeleteMapping("/{id}")
    UserDto deleteUserById(final @PathVariable("id") Integer id) {
        return mapUserToUserDto(userService.deleteUserById(id));
    }
}
