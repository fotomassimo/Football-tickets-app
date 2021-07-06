package football.tickets.app.service;

import football.tickets.app.model.GameEvent;
import java.time.LocalDate;
import java.util.List;

public interface GameEventService {
    List<GameEvent> findAvailableEvents(Long rivalryId, LocalDate date);

    GameEvent add(GameEvent gameEvent);

    GameEvent get(Long id);

    GameEvent update(GameEvent gameEvent);

    void delete(Long id);
}
