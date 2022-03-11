package emlakburada.repository;

import emlakburada.model.Message;
import emlakburada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
