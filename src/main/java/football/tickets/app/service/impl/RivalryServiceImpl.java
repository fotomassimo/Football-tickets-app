package football.tickets.app.service.impl;

import football.tickets.app.dao.RivalryDao;
import football.tickets.app.exception.DataProcessingException;
import football.tickets.app.model.Rivalry;
import football.tickets.app.service.RivalryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RivalryServiceImpl implements RivalryService {
    private final RivalryDao rivalryDao;

    public RivalryServiceImpl(RivalryDao rivalryDao) {
        this.rivalryDao = rivalryDao;
    }

    @Override
    public Rivalry add(Rivalry rivalry) {
        return rivalryDao.add(rivalry);
    }

    @Override
    public Rivalry get(Long id) {
        return rivalryDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get rivalry by id " + id));
    }

    @Override
    public List<Rivalry> getAll() {
        return rivalryDao.getAll();
    }
}
