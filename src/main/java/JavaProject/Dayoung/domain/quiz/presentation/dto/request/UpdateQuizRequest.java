package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.code.domain.Code;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateQuizRequest {

    private String title;

    private String question;

    private Level level;

    private Code code;

    private Area area;
}
