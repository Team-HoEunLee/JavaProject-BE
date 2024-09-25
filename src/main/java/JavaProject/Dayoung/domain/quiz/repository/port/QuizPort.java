package JavaProject.Dayoung.domain.quiz.repository.port;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;

import java.util.List;

public interface QuizPort {

    List<Quiz> queryAllByTitleAndAreasAndLevel(String title, List<Area> area, List<Level> level);

    Quiz findQuizById(Long id);

}
