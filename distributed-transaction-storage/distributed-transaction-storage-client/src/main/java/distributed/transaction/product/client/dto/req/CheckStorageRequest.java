package distributed.transaction.product.client.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * CheckStorageRequest
 *
 * @author hein
 */
@Data
public class CheckStorageRequest implements Serializable {

    private Long productId;

    private Integer quantity;
}
