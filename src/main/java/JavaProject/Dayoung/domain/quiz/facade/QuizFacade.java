package JavaProject.Dayoung.domain.quiz.facade;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.exception.QuizNotFoundException;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuizFacade {

    private final QuizRepository quizRepository;

    public Quiz getQuiz(Long quizId) {
        return quizRepository.findByQuizId(quizId)
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);
    }
}
