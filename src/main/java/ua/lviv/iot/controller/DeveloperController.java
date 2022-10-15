package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.developer.DeveloperDto;
import ua.lviv.iot.mappers.DeveloperMapper;
import ua.lviv.iot.model.Developer;
import ua.lviv.iot.service.DeveloperService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.DeveloperMapper.mapDeveloperToDeveloperDto;


@RestController
@AllArgsConstructor
@RequestMapping("/api/developer")
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    DeveloperDto createDeveloper(final @Valid @RequestBody Developer developer) {
        return mapDeveloperToDeveloperDto(developerService.createDeveloper(developer));
    }

    @GetMapping
    List<DeveloperDto> getAllDevelopers() {
        return developerService.getAllDevelopers().stream()
                .map(DeveloperMapper::mapDeveloperToDeveloperDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    DeveloperDto getDeveloperById(final @PathVariable("id") Integer id) {
        return mapDeveloperToDeveloperDto(developerService.getDeveloperById(id));
    }

    @PutMapping
    DeveloperDto updateDeveloper(final @Valid @RequestBody Developer developer) {
        return mapDeveloperToDeveloperDto(developerService.updateDeveloper(developer));
    }

    @DeleteMapping("/{id}")
    DeveloperDto deleteDeveloperById(final @PathVariable("id") Integer id) {
        return mapDeveloperToDeveloperDto(developerService.deleteDeveloperById(id));
    }
}
