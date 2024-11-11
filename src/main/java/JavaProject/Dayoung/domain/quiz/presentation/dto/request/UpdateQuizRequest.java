package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateQuizRequest {

    private String title;

    private String question;

    private Level level;

    private List<Long> codeIds;

    private List<Long> areaIds;
}
