package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.port.SolvedQuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizListService {

    private final QuizPort quizPort;
    private final SolvedQuizPort solvedQuizPort;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved, Pageable pageable) {

        List<Quiz> quizzes = quizPort.queryAllByTitleAndAreasAndLevel(title, area, level);

        //Page<Quiz> quizList = quizRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Direction.DESC, "id")));

        return quizzes.stream()
                .filter(quiz -> {
                    List<SolvedQuiz> solvedQuizzes = solvedQuizPort.queryAllById(quiz.getId());
                    return solvedQuizzes.stream().anyMatch(solvedQuiz -> solvedQuiz.getIsSolved() == isSolved);
                })
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
    }
}
