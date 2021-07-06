package football.tickets.app.dao;

import football.tickets.app.model.Order;
import football.tickets.app.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
