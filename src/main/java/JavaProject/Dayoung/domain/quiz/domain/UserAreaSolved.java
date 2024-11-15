package JavaProject.Dayoung.domain.quiz.domain;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

/*
    사용자별 푼 문제의 분야를 통계, 관리하는 엔티티

    각 사용자가 특정 분야에서 해결한 문제의 수를 추적합니다.
    User와 Area 엔티티와의 다대일 관계를 통해 통계 정보를 저장합니다.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserAreaSolved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @Column(nullable = false)
    private Long solvedCount;
}
