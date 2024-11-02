package distributed.transaction.product.client.dto.resp;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * QueryProductResponse
 *
 * @author hein
 */
@Data
public class QueryProductResponse implements Serializable {

    private BigDecimal price;
}
