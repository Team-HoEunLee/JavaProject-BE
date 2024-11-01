package JavaProject.Dayoung.domain.quiz.domain;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

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

    // 카운트를 증가시키는 메서드
    public void incrementSolvedCount() {
        this.solvedCount++;
    }
}
