package football.tickets.app.dao.impl;

import football.tickets.app.dao.AbstractDao;
import football.tickets.app.dao.GameEventDao;
import football.tickets.app.exception.DataProcessingException;
import football.tickets.app.model.GameEvent;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameEventDaoImpl extends AbstractDao<GameEvent, Long> implements GameEventDao {
    public GameEventDaoImpl(SessionFactory factory) {
        super(factory, GameEvent.class);
    }

    @Override
    public List<GameEvent> findAvailableEvents(Long rivalryId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<GameEvent> getAvailableEvent = session.createQuery(
                    "from GameEvent WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", GameEvent.class);
            getAvailableEvent.setParameter("id", rivalryId);
            getAvailableEvent.setParameter("date", date.toString());
            return getAvailableEvent.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Event for rivalry with id "
                    + rivalryId + " and game date " + date + " not found", e);
        }
    }
}
