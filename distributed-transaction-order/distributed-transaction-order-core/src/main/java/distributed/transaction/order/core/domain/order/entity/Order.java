package distributed.transaction.order.core.domain.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Order
 *
 * @author hein
 */
@Data
public class Order {

    private Long id;

    private Integer accountId;

    private Long productId;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal totalPrice;

    /**
     * 计算交易总额
     */
    public void calcTotalPrice() {
        totalPrice = price.multiply(new BigDecimal(quantity));
    }
}
