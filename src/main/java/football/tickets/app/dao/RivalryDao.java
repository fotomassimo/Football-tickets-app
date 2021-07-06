package football.tickets.app.dao;

import football.tickets.app.model.Rivalry;
import java.util.List;
import java.util.Optional;

public interface RivalryDao {
    Rivalry add(Rivalry rivalry);

    Optional<Rivalry> get(Long id);

    List<Rivalry> getAll();
}
