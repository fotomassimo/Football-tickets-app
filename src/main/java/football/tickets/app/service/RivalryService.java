package football.tickets.app.service;

import football.tickets.app.model.Rivalry;
import java.util.List;

public interface RivalryService {
    Rivalry add(Rivalry rivalry);

    Rivalry get(Long id);

    List<Rivalry> getAll();
}
