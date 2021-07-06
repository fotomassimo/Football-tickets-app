package football.tickets.app.dao;

import football.tickets.app.model.GameEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameEventDao {
    GameEvent add(GameEvent gameEvent);

    Optional<GameEvent> get(Long id);

    List<GameEvent> findAvailableEvents(Long rivalryId, LocalDate date);

    GameEvent update(GameEvent gameEvent);

    void delete(Long id);
}
