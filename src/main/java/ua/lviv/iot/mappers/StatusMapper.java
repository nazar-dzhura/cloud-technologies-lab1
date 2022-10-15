package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.status.StatusDto;
import ua.lviv.iot.model.Status;


public class StatusMapper {

    private StatusMapper() {
    }

    public static StatusDto mapStatusToStatusDto(Status status) {
        return new StatusDto(
                status.getId(),
                status.getStatus()
        );
    }
}