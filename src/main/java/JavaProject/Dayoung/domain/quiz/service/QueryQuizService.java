package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizService {

    private final QuizRepository quizRepository;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved) {

        return quizRepository.findAllByTitleContainingAndAreaInAndLevelInAndIsSolved(title, area, level, isSolved)
            .stream()
            .map(QuizListResponse::new)
            .collect(Collectors.toList());
    }
}
