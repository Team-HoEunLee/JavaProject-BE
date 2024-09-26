package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.repository.port.SolvedQuizPort;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static JavaProject.Dayoung.domain.quiz.entity.QSolvedQuiz.solvedQuiz;

@Repository
@RequiredArgsConstructor
public class SolvedQuizRepositoryImpl implements SolvedQuizPort {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SolvedQuiz> queryAllById(Long id) {
        return queryFactory
            .selectFrom(solvedQuiz)
            .where(solvedQuiz.id.eq(id))
            .fetch();
    }

    @Override
    public List<SolvedQuiz> queryAllByUserIdAndIsSolved(Long userId, IsSolved isSolved) {
        return queryFactory
            .selectFrom(solvedQuiz)
            .where(
                solvedQuiz.user.id.eq(userId),
                solvedQuiz.isSolved.eq(isSolved)
                )
            .fetch();
    }
}
