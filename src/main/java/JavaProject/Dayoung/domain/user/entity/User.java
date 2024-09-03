package JavaProject.Dayoung.domain.user.entity;

import JavaProject.Dayoung.domain.user.entity.type.Major;
import JavaProject.Dayoung.domain.user.entity.type.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String accountId;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(500)", nullable = true)
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Major major;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Integer score;

    @Builder
    public User(Long id, String accountId, String email, String password, String name, String introduction, Major major, Role role, Integer score) {
        this.id = id;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.introduction = introduction;
        this.major = major;
        this.role = role;
        this.score = score;
    }

    public void modifyInfo(String accountId, String name, Major major, String introduction) {
        this.accountId = accountId;
        this.name = name;
        this.major = major;
        this.introduction = introduction;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
