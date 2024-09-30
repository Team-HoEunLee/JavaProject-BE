package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizListService {

    private final QuizPort quizPort;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved, int page) {

        QuizFilter filter = QuizFilter.builder()
            .title(title)
            .areas(area)
            .levels(level)
            .isSolved(isSolved)
            .page(page)
            .limit(15)
            .build();

        return quizPort.queryAllByFilter(filter)
            .stream()
            .map(QuizListResponse::new)
            .collect(Collectors.toList());
    }
}
