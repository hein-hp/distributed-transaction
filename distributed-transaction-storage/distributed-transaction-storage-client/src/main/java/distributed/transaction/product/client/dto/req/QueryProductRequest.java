package distributed.transaction.product.client.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * QueryProductRequest
 *
 * @author hein
 */
@Data
public class QueryProductRequest implements Serializable {

    private Long productId;
}
