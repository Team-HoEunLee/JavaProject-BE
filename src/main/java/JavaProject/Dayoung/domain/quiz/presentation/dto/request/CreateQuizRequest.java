package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.code.domain.Code;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateQuizRequest {

    @NotNull(message = "제목을 입력하세요")
    @Size(min = 10, max = 300)
    private String title;

    @NotNull(message = "문제를 입력하세요")
    @Size(min = 10, max = 2000)
    private String question;

    @NotNull(message = "난이도를 선택해주세요")
    private Level level;

    private List<Area> areas;

    private List<Code> codes;
}
