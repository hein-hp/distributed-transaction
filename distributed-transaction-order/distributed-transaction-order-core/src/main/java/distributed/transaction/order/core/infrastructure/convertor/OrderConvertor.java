package distributed.transaction.order.core.infrastructure.convertor;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.core.infrastructure.model.OrderDO;
import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * OrderConvertor
 *
 * @author hein
 */
@Mapper
public interface OrderConvertor {

    OrderConvertor INSTANCE = Mappers.getMapper(OrderConvertor.class);

    OrderDO toOrderDO(Order order);

    @Mapping(target = "price", source = "totalPrice")
    CheckBalanceRequest toCheckBalanceRequest(Order order);

    @Mapping(target = "price", source = "totalPrice")
    DeductBalanceRequest toDeductBalanceRequest(Order order);

    DeductStorageRequest toDeductStorageRequest(Order order);

    CheckStorageRequest toCheckStorageRequest(Order order);

    QueryProductRequest toQueryProductRequest(Order order);
}
