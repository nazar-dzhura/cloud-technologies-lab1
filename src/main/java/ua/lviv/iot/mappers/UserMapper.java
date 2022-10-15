package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.user.UserDto;
import ua.lviv.iot.model.User;


public class UserMapper {

    private UserMapper() {
    }

    public static UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getNickname(),
                user.getStatus(),
                user.getLastPlayed(),
                user.getTotalPlaytime(),
                user.getGroup()

        );
    }
}