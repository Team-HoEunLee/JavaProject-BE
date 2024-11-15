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

    public QuizListResponse execute(QuizType quizType) {
        List<Quiz> quizzes = switch (quizType) {
            case BEGINNER -> quizPort.queryAllForBeginner();
            case RECENT -> quizPort.queryAllForRecent();
            case TEMPORARY -> quizPort.queryAllForTemporary();
            case MOST_SOLVED -> quizPort.queryAllForMostSolved();
        };

        List<QuizListResponse.QuizResponse> quizList = convertToQuizListResponse(quizzes);

        return new QuizListResponse(quizList);
    }

    private List<QuizListResponse.QuizResponse> convertToQuizListResponse(List<Quiz> quizzes) {
        return quizzes.stream()
                .map(QuizListResponse.QuizResponse::from)
                .collect(Collectors.toList());
    }
}
