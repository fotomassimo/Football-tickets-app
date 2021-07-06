package football.tickets.app.dao.impl;

import football.tickets.app.dao.AbstractDao;
import football.tickets.app.dao.RivalryDao;
import football.tickets.app.model.Rivalry;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RivalryDaoImpl extends AbstractDao<Rivalry, Long> implements RivalryDao {
    public RivalryDaoImpl(SessionFactory factory) {
        super(factory, Rivalry.class);
    }
}
