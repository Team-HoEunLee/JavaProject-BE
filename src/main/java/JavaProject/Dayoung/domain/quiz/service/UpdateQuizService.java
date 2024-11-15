package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.facade.QuizFacade;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.UpdateQuizRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateQuizService {

    private final QuizFacade quizFacade;

    public void execute(Long quizId, UpdateQuizRequest request) {
        Quiz quiz = quizFacade.getQuiz(quizId);

        quiz.updateQuiz(request.getTitle(), request.getQuestion(), request.getLevel(), request.getCodeIds(), request.getAreaIds(), request.getSolutions(), request.getAverage());
    }
}
