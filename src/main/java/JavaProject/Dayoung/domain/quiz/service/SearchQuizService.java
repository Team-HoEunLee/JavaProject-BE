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
public class SearchQuizService {

    private final QuizRepository quizRepository;

    @Transactional
    public QuizListResponse searchQuiz(String title) {
        List<QuizListResponse.QuizResponse> quizList = quizRepository.findAllByTitleContaining(title)
                .stream()
                .map(this::buildQuizList)
                .collect(Collectors.toList());

        return new QuizListResponse(quizList);
    }

    private QuizListResponse.QuizResponse buildQuizList(Quiz quiz) {
        return QuizListResponse.QuizResponse.builder()
                .quizId(quiz.getQuizId())
                .area(quiz.getArea())
                .level(quiz.getLevel())
                .title(quiz.getTitle())
                .question(quiz.getQuestion())
                .build();
    }
}
