package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.GroupDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Group;
import ua.lviv.iot.service.GroupService;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    @Override
    public Group createGroup(Group group) {
        return groupDao.save(group);
    }

    @Override
    public List<Group> getAllGroups() { return groupDao.findAll(); }

    @Override
    public Group getGroupById(Integer id) {
        return groupDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Group updateGroup(Group group) {
        getGroupById(group.getId()); // throws exception if entity doesn't exist
        return groupDao.save(group);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public Group deleteGroupById(Integer id) {
        Group oldGroup = getGroupById(id); // throws runtime exception if not found by id
        try {
            groupDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldGroup;
    }
}
