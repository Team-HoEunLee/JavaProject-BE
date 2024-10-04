package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.QuizType;
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
public class QueryBannerQuizService {

    private final QuizPort quizPort;

    public List<QuizListResponse> execute(QuizType quizType) {
        List<Quiz> quizzes = switch (quizType) {
            case BEGINNER -> quizPort.queryAllForBeginner();
            case RECENT -> quizPort.queryAllForRecent();
            case TEMPORARY -> quizPort.queryAllForTemporary();
            case MOST_SOLVED -> quizPort.queryAllForMostSolved();
        };
        return convertToQuizListResponse(quizzes);
    }

    private List<QuizListResponse> convertToQuizListResponse(List<Quiz> quizzes) {
        return quizzes.stream()
            .map(QuizListResponse::new)
            .collect(Collectors.toList());
    }
}
