package ua.lviv.iot.service;

import ua.lviv.iot.model.SystemRequirement;

import java.util.List;

public interface SystemRequirementService {

    SystemRequirement createSystemRequirement(SystemRequirement systemRequirement);

    List<SystemRequirement> getAllSystemRequirements();

    SystemRequirement getSystemRequirementById(Integer id);

    SystemRequirement updateSystemRequirement(SystemRequirement systemRequirement);

    SystemRequirement deleteSystemRequirementById(Integer id);
}
