package JavaProject.Dayoung.domain.code.repository;

import JavaProject.Dayoung.domain.code.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CodeRepository extends JpaRepository<Code, Long> {


}
