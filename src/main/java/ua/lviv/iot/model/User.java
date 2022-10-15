package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "`user`")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45, message = "must be up to 45 chars")
    @NotBlank(message = "is required and must not be blank")
    @Column(name = "nickname", nullable = false)
    private String nickname;

    @OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id",nullable = false)
    private Status status;

    @Column(name = "last_played")
    private LocalDateTime lastPlayed;

    @Column(name = "total_playtime")
    private Double totalPlaytime;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id",nullable = false)
    private Group group;

    public User(Integer id, String nickname, Status status, LocalDateTime lastPlayed, Double totalPlaytime, Group group) {
        this.id = id;
        this.nickname = nickname;
        this.status = status;
        this.lastPlayed = lastPlayed;
        this.totalPlaytime = totalPlaytime;
        this.group = group;
    }

    public User(String nickname, Status status, LocalDateTime lastPlayed, Double totalPlaytime, Group group) {
        this.nickname = nickname;
        this.status = status;
        this.lastPlayed = lastPlayed;
        this.totalPlaytime = totalPlaytime;
        this.group = group;
    }
}