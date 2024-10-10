package JavaProject.Dayoung.domain.quiz.domain;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.code.domain.Code;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(300)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(2000)", nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_id")
    private List<Code> code; //기술 스택

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private List<Area> area; // 분야

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void updateQuiz(String title, String question, Level level, List<Code> code, List<Area> area) {
        this.title = title;
        this.question = question;
        this.level = level;
        this.code = code;
        this.area = area;
    }
}
