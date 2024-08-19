package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.quiz.entity.type.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuizListResponse {

    private final List<QuizResponse> quizList;

    @Getter
    @Builder
    public static class QuizResponse {
        private final Long quizId;
        private final String title;
        private final String question;
        private final Area area;
        private final Level level;
    }
}
