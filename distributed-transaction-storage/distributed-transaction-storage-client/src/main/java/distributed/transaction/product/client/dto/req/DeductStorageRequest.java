package distributed.transaction.product.client.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * DeductStorageRequest
 *
 * @author hein
 */
@Data
public class DeductStorageRequest implements Serializable {

    private Long productId;

    private Integer quantity;
}
