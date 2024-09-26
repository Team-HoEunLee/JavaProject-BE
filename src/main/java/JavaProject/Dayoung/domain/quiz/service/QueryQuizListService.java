package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import JavaProject.Dayoung.domain.quiz.repository.port.SolvedQuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizListService {

    private final QuizPort quizPort;
    private final SolvedQuizPort solvedQuizPort;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved, Pageable pageable) {

        QuizFilter filter = QuizFilter.builder()
            .title(title)
            .areas(area)
            .levels(level)
            .page(pageable.getPageNumber())
            .limit(pageable.getPageSize())
            .build();

        List<Quiz> quizList = quizPort.queryAllByFilter(filter);

            //isSolved 같은 퀴즈로 변경하는 로직인데 개 쓰레기 같은 로직까진 아니지만 개 별로인 로직도 아니지만 안 좋은 로직인건 확실한
        //이게 application 영역에서 이렇게 관리를 해준다는거는 굉장히 성능적으로 안좋은 결과를 불러올 수도 있다는 점을 망각하지 말것

        return null;}
}
