package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`language`")
@NoArgsConstructor
@Getter
@Setter
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "language", nullable = false)
    private String language;

    public Language(Integer id, String language) {
        this.id = id;
        this.language = language;
    }

    public Language(String language) {
        this.language = language;
    }
}