package ua.lviv.iot.service;

import ua.lviv.iot.dto.user.CreateUpdateUserDto;
import ua.lviv.iot.model.User;

import java.util.List;

public interface UserService {

    User createUser(CreateUpdateUserDto createUpdateUserDto);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(CreateUpdateUserDto createUpdateUserDto);

    User deleteUserById(Integer id);
}
