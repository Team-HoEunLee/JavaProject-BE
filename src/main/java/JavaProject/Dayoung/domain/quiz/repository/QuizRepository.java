package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findByQuizId(Long quizId);

    @Query("select f from Quiz f join fetch f.user order by f.level DESC ")
    List<Quiz> findAllByJoinFetch();

    List<Quiz> findAllByTitleContaining(String title);
}