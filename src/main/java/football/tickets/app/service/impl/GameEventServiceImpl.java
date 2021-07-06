package football.tickets.app.service.impl;

import football.tickets.app.dao.GameEventDao;
import football.tickets.app.exception.DataProcessingException;
import football.tickets.app.model.GameEvent;
import football.tickets.app.service.GameEventService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GameEventServiceImpl implements GameEventService {
    private final GameEventDao gameEventDao;

    public GameEventServiceImpl(GameEventDao gameEventDao) {
        this.gameEventDao = gameEventDao;
    }

    @Override
    public List<GameEvent> findAvailableEvents(Long rivalryId, LocalDate date) {
        return gameEventDao.findAvailableEvents(rivalryId, date);
    }

    @Override
    public GameEvent add(GameEvent session) {
        return gameEventDao.add(session);
    }

    @Override
    public GameEvent get(Long id) {
        return gameEventDao.get(id).orElseThrow(
                () -> new DataProcessingException("Event with id " + id + " not found"));
    }

    @Override
    public GameEvent update(GameEvent gameEvent) {
        return gameEventDao.update(gameEvent);
    }

    @Override
    public void delete(Long id) {
        gameEventDao.delete(id);
    }
}
