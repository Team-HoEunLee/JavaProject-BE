package JavaProject.Dayoung.domain.quiz.entity;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.code.entity.Code;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz {

    @Column(columnDefinition = "varchar(300)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(2000)", nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_id", nullable = false)
    private Code code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @Builder
    public Quiz(Long id, String title, String question, Level level, Area area, Code code, User user, IsSolved isSolved) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.level = level;
        this.area = area;
        this.code = code;
        this.user = user;
        this.isSolved = isSolved;
    }
}
