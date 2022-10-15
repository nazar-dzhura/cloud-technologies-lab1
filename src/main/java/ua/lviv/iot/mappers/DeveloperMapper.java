package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.developer.DeveloperDto;
import ua.lviv.iot.model.Developer;


public class DeveloperMapper {

    private DeveloperMapper() {
    }

    public static DeveloperDto mapDeveloperToDeveloperDto(Developer developer) {
        return new DeveloperDto(
                developer.getId(),
                developer.getName()
        );
    }
}