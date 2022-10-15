package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.status.StatusDto;
import ua.lviv.iot.mappers.StatusMapper;
import ua.lviv.iot.model.Status;
import ua.lviv.iot.service.StatusService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.StatusMapper.mapStatusToStatusDto;


@RestController
@AllArgsConstructor
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    @PostMapping
    StatusDto createStatus(final @Valid @RequestBody Status status) {
        return mapStatusToStatusDto(statusService.createStatus(status));
    }

    @GetMapping
    List<StatusDto> getAllStatuses() {
        return statusService.getAllStatuses().stream()
                .map(StatusMapper::mapStatusToStatusDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    StatusDto getStatusById(final @PathVariable("id") Integer id) {
        return mapStatusToStatusDto(statusService.getStatusById(id));
    }

    @PutMapping
    StatusDto updateStatus(final @Valid @RequestBody Status status) {
        return mapStatusToStatusDto(statusService.updateStatus(status));
    }

    @DeleteMapping("/{id}")
    StatusDto deleteStatusById(final @PathVariable("id") Integer id) {
        return mapStatusToStatusDto(statusService.deleteStatusById(id));
    }
}
