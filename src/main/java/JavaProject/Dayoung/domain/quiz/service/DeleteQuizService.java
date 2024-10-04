package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.facade.QuizFacade;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteQuizService {

    private final QuizFacade quizFacade;
    private final QuizRepository quizRepository;

    public void execute(Long quizId) {
        Quiz quiz = quizFacade.getQuiz(quizId);

        quizRepository.delete(quiz);
    }
}
