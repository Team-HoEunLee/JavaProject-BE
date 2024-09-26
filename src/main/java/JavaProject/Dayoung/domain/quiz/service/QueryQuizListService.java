package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizListService {

    private final QuizPort quizPort;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved, Pageable pageable) {

        QuizFilter filter = QuizFilter.builder()
            .title(title)
            .areas(area)
            .levels(level)
            .page(pageable.getPageNumber())
            .limit(pageable.getPageSize())
            .build();

        List<Quiz> quizList = quizPort.queryAllByFilter(filter);

        return null;
    }
}
