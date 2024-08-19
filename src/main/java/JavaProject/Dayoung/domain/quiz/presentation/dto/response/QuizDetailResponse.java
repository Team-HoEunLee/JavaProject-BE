package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.quiz.entity.type.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizDetailResponse {

    private final Long quizId;
    private final String title;
    private final String question;
    private final Level level;
    private final Area area;
}
