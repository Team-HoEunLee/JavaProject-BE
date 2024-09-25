package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.repository.port.SolvedQuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SolvedQuizRepositoryImpl implements SolvedQuizPort {

    private final SolvedQuizRepository solvedQuizRepository;

    @Override
    public List<SolvedQuiz> queryAllById(Long id) {
        return solvedQuizRepository.findAllById(id);
    }

    @Override
    public List<SolvedQuiz> queryAllByUserIdAndIsSolved(Long userId, IsSolved isSolved) {
        return solvedQuizRepository.findAllByUserIdAndIsSolved(userId, isSolved);
    }
}
