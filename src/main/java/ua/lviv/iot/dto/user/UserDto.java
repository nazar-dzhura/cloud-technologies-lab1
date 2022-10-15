package ua.lviv.iot.dto.user;

import lombok.*;
import ua.lviv.iot.model.Group;
import ua.lviv.iot.model.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private Integer id;

    private String nickname;

    private Status status;

    private LocalDateTime lastPlayed;

    private Double totalPlaytime;

    private Group group;


}