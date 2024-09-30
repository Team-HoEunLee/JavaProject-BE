package JavaProject.Dayoung.domain.quiz.repository.port;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;

import java.util.List;

public interface QuizPort {

    List<Quiz> queryAllByFilter(QuizFilter quizFilter);

}
