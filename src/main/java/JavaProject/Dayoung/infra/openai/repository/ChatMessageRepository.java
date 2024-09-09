package JavaProject.Dayoung.infra.openai.repository;

import JavaProject.Dayoung.infra.openai.domain.ChatMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
}

