package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolvedQuizRepository extends CrudRepository<SolvedQuiz, Long> {

    List<SolvedQuiz> findAllByUserId(Long userId);
}
