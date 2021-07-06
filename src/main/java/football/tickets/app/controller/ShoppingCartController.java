package football.tickets.app.controller;

import football.tickets.app.dto.response.ShoppingCartResponseDto;
import football.tickets.app.model.GameEvent;
import football.tickets.app.model.User;
import football.tickets.app.service.GameEventService;
import football.tickets.app.service.ShoppingCartService;
import football.tickets.app.service.UserService;
import football.tickets.app.service.mapper.ShoppingCartMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final GameEventService gameEventService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  GameEventService gameEventService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.gameEventService = gameEventService;
    }

    @PostMapping("/game-events")
    public void addToCart(Authentication auth, @RequestParam Long gameEventId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        GameEvent gameEvent = gameEventService.get(gameEventId);
        shoppingCartService.addEvent(gameEvent, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername());
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
