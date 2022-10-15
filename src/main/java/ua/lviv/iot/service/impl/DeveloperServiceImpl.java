package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.DeveloperDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Developer;
import ua.lviv.iot.service.DeveloperService;

import java.util.List;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperDao developerDao;

    @Override
    public Developer createDeveloper(Developer developer) {
        return developerDao.save(developer);
    }

    @Override
    public List<Developer> getAllDevelopers() { return developerDao.findAll(); }

    @Override
    public Developer getDeveloperById(Integer id) {
        return developerDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Developer updateDeveloper(Developer developer) {
        getDeveloperById(developer.getId()); // throws exception if entity doesn't exist
        return developerDao.save(developer);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public Developer deleteDeveloperById(Integer id) {
        Developer oldDeveloper = getDeveloperById(id); // throws runtime exception if not found by id
        try {
            developerDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldDeveloper;
    }
}
