package football.tickets.app.service;

import football.tickets.app.model.GameEvent;
import football.tickets.app.model.ShoppingCart;
import football.tickets.app.model.User;

public interface ShoppingCartService {
    void addEvent(GameEvent gameEvent, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
