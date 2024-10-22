package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuizListResponse {

    private final Long quizId;

    private final String title;

    private final String question;

    private final List<Area> area;

    private final Level level;

    public QuizListResponse(Quiz quiz) {
        this.quizId = quiz.getId();
        this.title = quiz.getTitle();
        this.question = quiz.getQuestion();
        this.area = quiz.getArea();
        this.level = quiz.getLevel();
    }
}
