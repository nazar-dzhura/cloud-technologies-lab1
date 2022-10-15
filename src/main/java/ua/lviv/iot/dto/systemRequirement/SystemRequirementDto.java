package ua.lviv.iot.dto.systemRequirement;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SystemRequirementDto {

    private Integer id;

    private String type;

    private String minimal;

    private String recomended;
}