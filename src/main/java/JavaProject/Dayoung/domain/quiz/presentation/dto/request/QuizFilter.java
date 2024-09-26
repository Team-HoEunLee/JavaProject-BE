package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuizFilter {

    private final String title;
    private final List<Area> areas;
    private final List<Level> levels;
    private final IsSolved isSolved;
    private final int page;
    @Builder.Default
    private int limit = 15;
    public int getOffset() {
        return (page - 1) * limit;
    }
}
