package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.group.GroupDto;
import ua.lviv.iot.model.Group;


public class GroupMapper {

    private GroupMapper() {
    }

    public static GroupDto mapGroupToGroupDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getName()
        );
    }
}