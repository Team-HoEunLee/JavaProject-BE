package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findAllByTitleAndAreaInAndLevelIn(String title, List<Area> area, List<Level> level);

    Quiz findQuizById(Long id);

}
