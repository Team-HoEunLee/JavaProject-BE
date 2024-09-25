package JavaProject.Dayoung.domain.quiz.repository.port;

import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;

import java.util.List;

public interface SolvedQuizPort {

    List<SolvedQuiz> queryAllById(Long id);

    List<SolvedQuiz> queryAllByUserIdAndIsSolved(Long userId, IsSolved isSolved);

}
