package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.UserDao;
import ua.lviv.iot.dto.user.CreateUpdateUserDto;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.InvalidDateTimeException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Group;
import ua.lviv.iot.model.Status;
import ua.lviv.iot.model.User;
import ua.lviv.iot.service.GroupService;
import ua.lviv.iot.service.StatusService;
import ua.lviv.iot.service.UserService;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final StatusService statusService;
    private final GroupService groupService;

    @Override
    public User createUser(CreateUpdateUserDto createUpdateUserDto) {
        Status status = statusService.getStatusById(createUpdateUserDto.getStatusId());
        Group group = groupService.getGroupById(createUpdateUserDto.getGroupId());

        LocalDateTime lastPlayed;
        try {
            lastPlayed = LocalDateTime.parse(createUpdateUserDto.getLastPlayed());
        } catch (DateTimeException e) {
            throw new InvalidDateTimeException("enter valid datetime");
        }
        return userDao.save(new User(
                createUpdateUserDto.getNickname(),
                status,
                lastPlayed,
                createUpdateUserDto.getTotalPlaytime(),
                group
        ));
    }

    @Override
    public List<User> getAllUsers() { return userDao.findAll(); }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public User updateUser(CreateUpdateUserDto createUpdateUserDto) {
        getUserById(createUpdateUserDto.getId()); // will throw exception if entity doesn't exist
        Status status = statusService.getStatusById(createUpdateUserDto.getStatusId());
        Group group = groupService.getGroupById(createUpdateUserDto.getGroupId());

        LocalDateTime lastPlayed;
        try {
            lastPlayed = LocalDateTime.parse(createUpdateUserDto.getLastPlayed());
        } catch (DateTimeException e) {
            throw new InvalidDateTimeException("enter valid datetime");
        }
        return userDao.save(new User(
                createUpdateUserDto.getId(),
                createUpdateUserDto.getNickname(),
                status,
                lastPlayed,
                createUpdateUserDto.getTotalPlaytime(),
                group
        ));
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public User deleteUserById(Integer id) {
        User oldUser = getUserById(id); // throws runtime exception if not found by id
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldUser;
    }
}
