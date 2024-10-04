package JavaProject.Dayoung.domain.quiz.repository;


import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.QuizFilter;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static JavaProject.Dayoung.domain.quiz.domain.QQuiz.quiz;
import static JavaProject.Dayoung.domain.quiz.domain.QSolvedQuiz.solvedQuiz;

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

    @Override
    public List<Quiz> queryAllForBeginner() {
        return queryFactory
            .selectFrom(quiz)
            .where(quiz.level.eq(Level.EASY))
            .limit(15)
            .fetch();
    }

    @Override
    public List<Quiz> queryAllForRecent() {
        return queryFactory
            .selectFrom(quiz)
            .orderBy(quiz.createdAt.desc())
            .limit(15)
            .fetch();
    }

    @Override
    public List<Quiz> queryAllForTemporary() {
        return queryFactory
            .selectFrom(quiz)
            //임시로 만들어둔 쿼리문입니다
            .limit(15)
            .fetch();
    }

    @Override
    public List<Quiz> queryAllForMostSolved() {
        return queryFactory
            .selectFrom(quiz)
            .join(solvedQuiz).on(solvedQuiz.quiz.eq(quiz))
            .groupBy(solvedQuiz.quiz.id)
            .orderBy(solvedQuiz.count().desc())
            .limit(15)
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
