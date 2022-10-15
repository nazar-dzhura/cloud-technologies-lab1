package ua.lviv.iot.dto.status;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUpdateStatusDto {

    private Integer id;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    private String status;
}