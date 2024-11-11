package JavaProject.Dayoung.domain.user.domain;

import JavaProject.Dayoung.domain.user.domain.type.Role;
import JavaProject.Dayoung.global.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String accountId;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(500)")
    private String introduction;

    @Convert(converter = StringListConverter.class)
    private List<Long> areaIds = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Integer score;

    public void modifyInfo(String accountId, String name, List<Long> areaIds, String introduction) {
        this.accountId = accountId;
        this.name = name;
        this.areaIds = areaIds;
        this.introduction = introduction;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
