package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.SystemRequirementDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.SystemRequirement;
import ua.lviv.iot.service.SystemRequirementService;

import java.util.List;

@Service
@AllArgsConstructor
public class SystemRequirementServiceImpl implements SystemRequirementService {

    private final SystemRequirementDao systemRequirementDao;

    @Override
    public SystemRequirement createSystemRequirement(SystemRequirement systemRequirement) {
        return systemRequirementDao.save(systemRequirement);
    }

    @Override
    public List<SystemRequirement> getAllSystemRequirements() { return systemRequirementDao.findAll(); }

    @Override
    public SystemRequirement getSystemRequirementById(Integer id) {
        return systemRequirementDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public SystemRequirement updateSystemRequirement(SystemRequirement systemRequirement) {
        getSystemRequirementById(systemRequirement.getId()); // throws exception if entity doesn't exist
        return systemRequirementDao.save(systemRequirement);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public SystemRequirement deleteSystemRequirementById(Integer id) {
        SystemRequirement oldSystemRequirement = getSystemRequirementById(id); // throws runtime exception if not found by id
        try {
            systemRequirementDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldSystemRequirement;
    }
}
