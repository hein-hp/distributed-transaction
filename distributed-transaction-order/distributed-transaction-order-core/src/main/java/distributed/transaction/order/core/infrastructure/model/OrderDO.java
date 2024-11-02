package distributed.transaction.order.core.infrastructure.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * OrderDO
 *
 * @author hein
 */
@TableName("t_order")
@Data
public class OrderDO {

    /**
    * 订单 id
    */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
    * 账户 id
    */
    private Integer accountId;

    /**
    * 商品 id
    */
    private Long productId;

    /**
    * 交易金额
    */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer quantity;
}