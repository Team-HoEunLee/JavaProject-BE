package JavaProject.Dayoung.domain.user.repository;

import JavaProject.Dayoung.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);

    List<User> findTop10ByOrderByScoreDesc();

}
