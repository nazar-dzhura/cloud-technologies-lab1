package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.group.GroupDto;
import ua.lviv.iot.mappers.GroupMapper;
import ua.lviv.iot.model.Group;
import ua.lviv.iot.service.GroupService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.lviv.iot.mappers.GroupMapper.mapGroupToGroupDto;


@RestController
@AllArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    GroupDto createGroup(final @Valid @RequestBody Group group) {
        return mapGroupToGroupDto(groupService.createGroup(group));
    }

    @GetMapping
    List<GroupDto> getAllGroups() {
        return groupService.getAllGroups().stream()
                .map(GroupMapper::mapGroupToGroupDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    GroupDto getGroupById(final @PathVariable("id") Integer id) {
        return mapGroupToGroupDto(groupService.getGroupById(id));
    }

    @PutMapping
    GroupDto updateGroup(final @Valid @RequestBody Group group) {
        return mapGroupToGroupDto(groupService.updateGroup(group));
    }

    @DeleteMapping("/{id}")
    GroupDto deleteGroupById(final @PathVariable("id") Integer id) {
        return mapGroupToGroupDto(groupService.deleteGroupById(id));
    }
}
