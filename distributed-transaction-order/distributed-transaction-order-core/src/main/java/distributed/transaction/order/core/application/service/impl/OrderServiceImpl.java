package distributed.transaction.order.core.application.service.impl;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.account.client.dto.resp.CheckBalanceResponse;
import distributed.transaction.order.core.application.adapter.AccountServiceAdapter;
import distributed.transaction.order.core.application.adapter.ProductServiceAdapter;
import distributed.transaction.order.core.application.service.OrderService;
import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.core.domain.order.service.OrderDomainService;
import distributed.transaction.order.core.infrastructure.convertor.OrderConvertor;
import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import distributed.transaction.product.client.dto.resp.CheckStorageResponse;
import distributed.transaction.product.client.dto.resp.QueryProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderServiceImpl
 *
 * @author hein
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private AccountServiceAdapter accountServiceAdapter;

    @Autowired
    private ProductServiceAdapter productServiceAdapter;

    @Override
    @Transactional
    public void createOrder(Order order) {
        // 查询商品单价
        QueryProductRequest request = OrderConvertor.INSTANCE.toQueryProductRequest(order);
        QueryProductResponse response = productServiceAdapter.queryProduct(request);
        order.setPrice(response.getPrice());
        order.calcTotalPrice();

        // 扣减余额
        CheckBalanceRequest checkBalanceRequest = OrderConvertor.INSTANCE.toCheckBalanceRequest(order);
        CheckBalanceResponse checkBalanceResponse = accountServiceAdapter.checkBalance(checkBalanceRequest);
        if (!checkBalanceResponse.getIsEnough()) {
            throw new RuntimeException("余额不足");
        }
        DeductBalanceRequest deductBalanceRequest = OrderConvertor.INSTANCE.toDeductBalanceRequest(order);
        accountServiceAdapter.deductBalance(deductBalanceRequest);

        // 扣减库存
        CheckStorageRequest checkStorageRequest = OrderConvertor.INSTANCE.toCheckStorageRequest(order);
        CheckStorageResponse checkStorageResponse = productServiceAdapter.checkStorage(checkStorageRequest);
        if (!checkStorageResponse.getIsEnough()) {
            throw new RuntimeException("库存不足");
        }
        DeductStorageRequest deductStorageRequest = OrderConvertor.INSTANCE.toDeductStorageRequest(order);
        productServiceAdapter.deductStorage(deductStorageRequest);

        // 创建订单
        orderDomainService.createOrder(order);
    }
}
