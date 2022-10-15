package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.systemRequirement.SystemRequirementDto;
import ua.lviv.iot.mappers.SystemRequirementMapper;
import ua.lviv.iot.model.SystemRequirement;
import ua.lviv.iot.service.SystemRequirementService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.SystemRequirementMapper.mapSystemRequirementToSystemRequirementDto;


@RestController
@AllArgsConstructor
@RequestMapping("/api/system-requirement")
public class SystemRequirementController {

    private final SystemRequirementService systemRequirementService;

    @PostMapping
    SystemRequirementDto createSystemRequirement(final @Valid @RequestBody SystemRequirement systemRequirement) {
        return mapSystemRequirementToSystemRequirementDto(systemRequirementService.createSystemRequirement(systemRequirement));
    }

    @GetMapping
    List<SystemRequirementDto> getAllSystemRequirements() {
        return systemRequirementService.getAllSystemRequirements().stream()
                .map(SystemRequirementMapper::mapSystemRequirementToSystemRequirementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    SystemRequirementDto getSystemRequirementById(final @PathVariable("id") Integer id) {
        return mapSystemRequirementToSystemRequirementDto(systemRequirementService.getSystemRequirementById(id));
    }

    @PutMapping
    SystemRequirementDto updateSystemRequirement(final @Valid @RequestBody SystemRequirement systemRequirement) {
        return mapSystemRequirementToSystemRequirementDto(systemRequirementService.updateSystemRequirement(systemRequirement));
    }

    @DeleteMapping("/{id}")
    SystemRequirementDto deleteSystemRequirementById(final @PathVariable("id") Integer id) {
        return mapSystemRequirementToSystemRequirementDto(systemRequirementService.deleteSystemRequirementById(id));
    }
}
