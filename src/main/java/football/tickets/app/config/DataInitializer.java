package football.tickets.app.config;

import football.tickets.app.model.Role;
import football.tickets.app.model.User;
import football.tickets.app.service.RoleService;
import football.tickets.app.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private RoleService roleService;
    private UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void injectData() {
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.USER));
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1234");
        admin.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        userService.add(admin);
    }
}
