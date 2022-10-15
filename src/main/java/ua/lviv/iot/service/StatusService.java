package ua.lviv.iot.service;

import ua.lviv.iot.model.Status;

import java.util.List;

public interface StatusService {

    Status createStatus(Status status);

    List<Status> getAllStatuses();

    Status getStatusById(Integer id);

    Status updateStatus(Status status);

    Status deleteStatusById(Integer id);
}
