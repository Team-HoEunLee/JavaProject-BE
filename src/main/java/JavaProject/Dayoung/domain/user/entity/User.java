package JavaProject.Dayoung.domain.user.entity;

import JavaProject.Dayoung.domain.user.entity.type.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Column(columnDefinition = "varchar(80)", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long id, String accountId, String email, String password, Role role) {
        this.id = id;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
