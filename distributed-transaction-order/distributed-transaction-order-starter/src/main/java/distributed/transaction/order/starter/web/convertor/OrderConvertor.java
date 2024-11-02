package distributed.transaction.order.starter.web.convertor;

import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.starter.web.param.OrderCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * OrderConvertor
 *
 * @author hein
 */
@Mapper
public interface OrderConvertor {

    OrderConvertor INSTANCE = Mappers.getMapper(OrderConvertor.class);

    Order toOrder(OrderCreateRequest request);
}
