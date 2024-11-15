package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserAreaSolvedResponse {

    @NotNull(message = "영역은 null일 수 없습니다")
    private List<Long> areaIds;

    @NotNull(message = "해결한 문제 수는 null일 수 없습니다")
    @PositiveOrZero(message = "해결한 문제 수는 0 이상이어야 합니다")
    private Long solvedCount;
}
