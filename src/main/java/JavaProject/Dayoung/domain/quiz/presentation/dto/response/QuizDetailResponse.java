package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizDetailResponse {

    private final Long quizId;
    private final String title;
    private final String question;
    private final Level level;
    private final Area area;

    public QuizDetailResponse(Quiz quiz) {
        quizId = quiz.getQuizId();
        title = quiz.getTitle();
        question = quiz.getQuestion();
        level = quiz.getLevel();
        area = quiz.getArea();
    }
}
