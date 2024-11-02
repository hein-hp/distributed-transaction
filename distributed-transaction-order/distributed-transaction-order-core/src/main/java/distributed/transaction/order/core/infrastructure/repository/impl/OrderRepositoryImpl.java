package distributed.transaction.order.core.infrastructure.repository.impl;

import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.core.infrastructure.model.OrderDO;
import distributed.transaction.order.core.infrastructure.repository.OrderRepository;
import distributed.transaction.order.core.infrastructure.convertor.OrderConvertor;
import distributed.transaction.order.core.infrastructure.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * OrderRepositoryImpl
 *
 * @author hein
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        OrderDO orderDO = OrderConvertor.INSTANCE.toOrderDO(order);
        orderMapper.insert(orderDO);
    }
}
