package distributed.transaction.order.starter.web.controller;

import distributed.transaction.order.core.application.service.OrderService;
import distributed.transaction.order.core.domain.order.entity.Order;
import distributed.transaction.order.starter.web.convertor.OrderConvertor;
import distributed.transaction.order.starter.web.param.OrderCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author hein
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/version")
    public String version() {
        return "v1.0.0";
    }

    @PostMapping("/order/create")
    public String createOrder(@RequestBody OrderCreateRequest request) {
        Order order = OrderConvertor.INSTANCE.toOrder(request);
        orderService.createOrder(order);
        return "success";
    }
}
