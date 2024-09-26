package JavaProject.Dayoung.domain.quiz.repository;


import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static JavaProject.Dayoung.domain.quiz.entity.QQuiz.quiz;
import static JavaProject.Dayoung.domain.quiz.entity.QSolvedQuiz.solvedQuiz;

@Repository
@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizPort {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Quiz> queryAllByFilter(QuizFilter filter) {
        return queryFactory
            .selectFrom(quiz)
            .join(solvedQuiz)
            .on(solvedQuiz.id.eq(quiz.id))
            .where(containsTitle(filter.getTitle()),
                containsArea(filter.getAreas()),
                containsLevel(filter.getLevels()),
                equalsIsSolved(filter.getIsSolved()))
            .orderBy(quiz.id.asc())
            .offset(filter.getOffset())
            .limit(filter.getLimit())
            .fetch();
    }

    private BooleanExpression containsTitle(String title) {
        return title == null ? null : quiz.title.contains(title);
    }

    private BooleanExpression containsArea(List<Area> areas) {
        return areas == null ? null : quiz.area.in(areas);
    }

    private BooleanExpression containsLevel(List<Level> levels) {
        return levels == null ? null : quiz.level.in(levels);
    }

    private BooleanExpression equalsIsSolved(IsSolved isSolved) {
        return isSolved == null ? null : solvedQuiz.isSolved.in(isSolved);
    }

}
