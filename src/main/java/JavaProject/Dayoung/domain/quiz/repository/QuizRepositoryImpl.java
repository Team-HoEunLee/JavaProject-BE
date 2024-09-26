package JavaProject.Dayoung.domain.quiz.repository;


import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.QQuiz;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static JavaProject.Dayoung.domain.quiz.entity.QQuiz.quiz;

@Repository
@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizPort {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Quiz> queryAllByTitleAndAreasAndLevel(String title, List<Area> area, List<Level> level) {
        return queryFactory
            .selectFrom(quiz)
            .where(quiz.title.contains(title)
                .and(quiz.area.in(area))
                .and(quiz.level.in(level)))
            .fetch();
    }

    @Override
    public Quiz queryQuizById(Long id) {
        return queryFactory
            .selectFrom(quiz)
            .where(quiz.id.eq(id))
            .fetchOne();
    }
}
