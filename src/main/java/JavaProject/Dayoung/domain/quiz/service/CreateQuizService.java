package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateQuizService {

    private final QuizRepository quizRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createQuiz(CreateQuizRequest request) {
        User user = userFacade.getCurrentUser();

        quizRepository.save(Quiz.builder()
                .area(request.getArea())
                .level(request.getLevel())
                .question(request.getQuestion())
                .title(request.getTitle())
                .user(user)
                .build());
    }
}
