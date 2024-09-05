package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAllByTitleContainingAndAreaInAndLevelInAndIsSolved(String title, List<Area> area, List<Level> level, IsSolved isSolved);

    Quiz findQuizById(Long id);

    List<Quiz> findAllByTitleContaining(String title);
}
