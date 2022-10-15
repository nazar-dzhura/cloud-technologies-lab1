package ua.lviv.iot.dto.developer;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUpdateDeveloperDto {

    private Integer id;

    @Size(max = 60, message = "must be up to 60 chars")
    @NotBlank(message = "is required and must not be blank")
    private String name;
}