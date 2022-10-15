package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.systemRequirement.SystemRequirementDto;
import ua.lviv.iot.model.SystemRequirement;


public class SystemRequirementMapper {

    private SystemRequirementMapper() {
    }

    public static SystemRequirementDto mapSystemRequirementToSystemRequirementDto(SystemRequirement systemRequirement) {
        return new SystemRequirementDto(
                systemRequirement.getId(),
                systemRequirement.getType(),
                systemRequirement.getMinimal(),
                systemRequirement.getRecomended()

        );
    }
}