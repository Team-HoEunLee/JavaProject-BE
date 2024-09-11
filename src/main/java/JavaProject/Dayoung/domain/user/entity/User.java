package JavaProject.Dayoung.domain.user.entity;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.code.entity.Code;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.user.entity.type.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = true)
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_id", nullable = true)
    private Code code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    private Integer score;

    @Builder
    public User(Long id, String accountId, String email, String password, String name, String introduction, Area area, Role role, Code code, Integer score, List<Quiz> quizzes) {
        this.id = id;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.introduction = introduction;
        this.area = area;
        this.role = role;
        this.code = code;
        this.score = score;
        this.quizzes = quizzes;
    }

    public void modifyInfo(String accountId, String name, Area area, String introduction, Code code) {
        this.accountId = accountId;
        this.name = name;
        this.area = area;
        this.introduction = introduction;
        this.code = code;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
