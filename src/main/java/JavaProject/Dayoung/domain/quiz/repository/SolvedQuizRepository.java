package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedQuizRepository extends CrudRepository<SolvedQuiz, Long> {
}
