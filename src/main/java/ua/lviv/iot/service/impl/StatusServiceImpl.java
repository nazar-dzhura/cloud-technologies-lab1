package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.StatusDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Status;
import ua.lviv.iot.service.StatusService;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusDao statusDao;

    @Override
    public Status createStatus(Status status) {
        return statusDao.save(status);
    }

    @Override
    public List<Status> getAllStatuses() { return statusDao.findAll(); }

    @Override
    public Status getStatusById(Integer id) {
        return statusDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Status updateStatus(Status status) {
        getStatusById(status.getId()); // throws exception if entity doesn't exist
        return statusDao.save(status);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public Status deleteStatusById(Integer id) {
        Status oldStatus = getStatusById(id); // throws runtime exception if not found by id
        try {
            statusDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldStatus;
    }
}
