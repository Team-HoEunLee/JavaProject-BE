package JavaProject.Dayoung.domain.quiz.repository;


import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.Quiz;
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
                equalsIsSolved(filter.isSolved()))
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
        //return areas == null ? null : quiz.area.in(areas);
        return areas == null ? null : quiz.area.contains((Area) areas);
    }

    private BooleanExpression containsLevel(List<Level> levels) {
        return levels == null ? null : quiz.level.in(levels);
    }

    private BooleanExpression equalsIsSolved(Boolean isSolved) {
        // (isSolved) 방식은 null일 경우, NPE를 발생시키기에 null을 처리해줘야 하기 때문에 Boolean.TRUE를 사용했습니다.
        if (Boolean.TRUE.equals(isSolved)) {
            return solvedQuiz.quiz.id.eq(quiz.id);
        } else if (Boolean.FALSE.equals(isSolved)) {
            return solvedQuiz.quiz.id.ne(quiz.id);
        }
        return null;
    }
}
