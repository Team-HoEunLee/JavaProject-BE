package JavaProject.Dayoung.domain.quiz.repository;


import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizPort {

    private final JPAQueryFactory queryFactory;
    private final QuizRepository quizRepository;

    @Override
    public List<Quiz> queryAllByTitleAndAreasAndLevel(String title, List<Area> area, List<Level> level) {
        return quizRepository.findAllByTitleContainingAndAreaInAndLevelIn(title, area, level);
    }

    @Override
    public Quiz findQuizById(Long id) {
        return quizRepository.findQuizById(id);
    }
}
