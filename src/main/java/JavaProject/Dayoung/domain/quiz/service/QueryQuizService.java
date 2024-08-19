package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuizService {

    private final QuizRepository quizRepository;

    @Transactional(readOnly = true)
    public QuizListResponse getQuizList() {
        List<QuizListResponse.QuizResponse> quizList = quizRepository.findAllByJoinFetch()
                .stream()
                .map(this::buildQuizList)
                .collect(Collectors.toList());
        return new QuizListResponse(quizList);
    }

    private QuizListResponse.QuizResponse buildQuizList(Quiz quiz) {
        return QuizListResponse.QuizResponse.builder()
                .quizId(quiz.getQuizId())
                .title(quiz.getTitle())
                .level(quiz.getLevel())
                .area(quiz.getArea())
                .build();
    }
}
