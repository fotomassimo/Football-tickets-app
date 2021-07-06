package football.tickets.app.service.impl;

import football.tickets.app.model.User;
import football.tickets.app.service.AuthenticationService;
import football.tickets.app.service.RoleService;
import football.tickets.app.service.ShoppingCartService;
import football.tickets.app.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
