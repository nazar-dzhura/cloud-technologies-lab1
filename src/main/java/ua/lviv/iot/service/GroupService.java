package ua.lviv.iot.service;

import ua.lviv.iot.model.Group;

import java.util.List;

public interface GroupService {

    Group createGroup(Group group);

    List<Group> getAllGroups();

    Group getGroupById(Integer id);

    Group updateGroup(Group group);

    Group deleteGroupById(Integer id);
}
