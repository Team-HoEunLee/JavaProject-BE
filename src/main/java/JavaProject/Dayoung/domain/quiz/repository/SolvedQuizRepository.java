package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.domain.type.IsSolved;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolvedQuizRepository extends CrudRepository<SolvedQuiz, Long> {

    List<SolvedQuiz> findAllByUserIdAndIsSolved(Long userId, IsSolved isSolved);
}
