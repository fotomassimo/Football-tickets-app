package football.tickets.app.service.impl;

import football.tickets.app.dao.RoleDao;
import football.tickets.app.exception.DataProcessingException;
import football.tickets.app.model.Role;
import football.tickets.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role with name " + roleName + " not found"));
    }
}
