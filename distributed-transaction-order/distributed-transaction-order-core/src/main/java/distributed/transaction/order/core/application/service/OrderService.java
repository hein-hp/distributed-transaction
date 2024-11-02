package distributed.transaction.order.core.application.service;

import distributed.transaction.order.core.domain.order.entity.Order;

/**
 * OrderAppService
 *
 * @author hein
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void createOrder(Order order);
}