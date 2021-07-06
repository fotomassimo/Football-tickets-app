package football.tickets.app.dao.impl;

import football.tickets.app.dao.AbstractDao;
import football.tickets.app.dao.RoleDao;
import football.tickets.app.exception.DataProcessingException;
import football.tickets.app.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getRoleByName = session.createQuery(
                    "from Role WHERE roleName = :roleName", Role.class);
            getRoleByName.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return getRoleByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role " + roleName + " not found", e);
        }
    }
}
