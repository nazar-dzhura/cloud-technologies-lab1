package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`system_requirement`")
@NoArgsConstructor
@Getter
@Setter
public class SystemRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "type", nullable = false)
    private String type;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "minimal", nullable = false)
    private String minimal;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "recomended", nullable = false)
    private String recomended;

    public SystemRequirement(Integer id, String type, String minimal, String recomended) {
        this.id = id;
        this.type = type;
        this.minimal = minimal;
        this.recomended = recomended;
    }

    public SystemRequirement(String type, String minimal, String recomended) {
        this.type = type;
        this.minimal = minimal;
        this.recomended = recomended;
    }
}