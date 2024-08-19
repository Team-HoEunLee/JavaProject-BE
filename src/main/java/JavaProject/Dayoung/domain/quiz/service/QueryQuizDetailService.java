package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.facade.QuizFacade;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryQuizDetailService {

    private final QuizFacade quizFacade;

    @Transactional
    public QuizDetailResponse getQuizDetail(Long quizId) {
        Quiz quiz = quizFacade.getQuiz(quizId);

        return QuizDetailResponse.builder()
                .area(quiz.getArea())
                .title(quiz.getTitle())
                .level(quiz.getLevel())
                .question(quiz.getQuestion())
                .build();
    }
}
