package football.tickets.app.service;

import football.tickets.app.model.Order;
import football.tickets.app.model.ShoppingCart;
import football.tickets.app.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
