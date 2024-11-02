package distributed.transaction.order.starter.web.param;

import lombok.Data;

/**
 * OrderCreateRequest
 *
 * @author hein
 */
@Data
public class OrderCreateRequest {

    private Long accountId;

    private Long productId;

    private Long quantity;
}
