package distributed.transaction.order.core.infrastructure.repository;

import distributed.transaction.order.core.domain.order.entity.Order;

/**
 * AccountRepository
 *
 * @author hein
 */
public interface OrderRepository {

    void createOrder(Order order);
}
