package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.UserAreaSolved;
import JavaProject.Dayoung.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAreaSolvedRepository extends JpaRepository<UserAreaSolved, Long> {
    Optional<UserAreaSolved> findByUserAndArea(User user, Area area);

    @Query("SELECT uas FROM UserAreaSolved uas WHERE uas.user.id = :userId")
    List<UserAreaSolved> findAllByUserId(@Param("userId") Long userId);
}
