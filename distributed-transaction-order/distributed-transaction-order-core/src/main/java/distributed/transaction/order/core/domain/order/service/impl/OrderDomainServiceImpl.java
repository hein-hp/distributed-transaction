package distributed.transaction.order.core.domain.order.service.impl;

import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.core.domain.order.service.OrderDomainService;
import distributed.transaction.order.core.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderDomainServiceImpl
 *
 * @author hein
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }
}
