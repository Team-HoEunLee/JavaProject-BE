package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuizListResponse {

    private final List<QuizResponse> quizResponse;

    @Getter
    @Builder
    public static class QuizResponse {

        private final Long quizId;

        private final String title;

        private final String question;

        private final List<Area> area;

        private final Level level;

        private final int avgScore;

        public static QuizResponse from(Quiz quiz) {
            return QuizResponse.builder()
                .quizId(quiz.getId())
                .title(quiz.getTitle())
                .question(quiz.getQuestion())
                .area(quiz.getArea())
                .level(quiz.getLevel())
                .avgScore(0)
                .build();
        }
    }
}
