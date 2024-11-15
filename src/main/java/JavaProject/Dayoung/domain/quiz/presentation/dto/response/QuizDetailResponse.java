package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuizDetailResponse {

    private final Long quizId;

    private final String title;

    private final String question;

    private final Level level;

    private final List<Long> areas;

    private final List<Long> codes;

    public QuizDetailResponse(Quiz quiz) {
        quizId = quiz.getId();
        title = quiz.getTitle();
        question = quiz.getQuestion();
        level = quiz.getLevel();
        areas = quiz.getAreaIds();
        codes = quiz.getCodeIds();
    }
}
