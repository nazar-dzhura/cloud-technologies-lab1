package ua.lviv.iot.dto.user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUpdateUserDto {

    private Integer id;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    private String nickname;

    @NotNull(message = "is required and must not be blank")
    private Integer statusId;

    @NotNull(message = "is required and must not be blank")
    private Integer groupId;

    @Pattern(regexp = "(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})\\.(\\d{2})",
            message = "time must match pattern: yyyy-mm-ddThh:mm:ss.xx")
    private String lastPlayed;

    private Double totalPlaytime;


}