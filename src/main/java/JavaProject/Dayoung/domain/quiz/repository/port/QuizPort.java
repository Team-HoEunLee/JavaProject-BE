package JavaProject.Dayoung.domain.quiz.repository.port;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;

import java.util.List;

public interface QuizPort {

    List<Quiz> queryAllByFilter(QuizFilter quizFilter);

    Quiz queryQuizById(Long id);

}
