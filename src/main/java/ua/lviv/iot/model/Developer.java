package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`developer`")
@NoArgsConstructor
@Getter
@Setter
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 60, message = "must be up to 60 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "name", nullable = false)
    private String name;

    public Developer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Developer(String name) {
        this.name = name;
    }
}