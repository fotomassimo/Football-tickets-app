package football.tickets.app.dao;

import football.tickets.app.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
