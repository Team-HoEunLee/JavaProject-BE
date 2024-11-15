package JavaProject.Dayoung.domain.quiz.domain;

import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import JavaProject.Dayoung.global.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Convert(converter = StringListConverter.class)
    private List<Long> codeIds = new ArrayList<>(); //기술 스택

    @Convert(converter = StringListConverter.class)
    private List<Long> areaIds = new ArrayList<>(); // 분야

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private int solutions;

    @Column(nullable = false)
    private int average;

    public void updateQuiz(String title, String question, Level level, List<Long> codeIds, List<Long> areaIds, int solutions, int average) {
        this.title = title;
        this.question = question;
        this.level = level;
        this.codeIds = codeIds;
        this.areaIds = areaIds;
        this.solutions = solutions;
        this.average = average;
    }
}
