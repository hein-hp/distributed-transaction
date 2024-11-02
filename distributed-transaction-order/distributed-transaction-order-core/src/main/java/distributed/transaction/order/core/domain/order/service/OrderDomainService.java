package distributed.transaction.order.core.domain.order.service;

import distributed.transaction.order.core.domain.order.entity.Order;

/**
 * OrderDomainService
 *
 * @author hein
 */
public interface OrderDomainService {

    void createOrder(Order order);
}
