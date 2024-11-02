package distributed.transaction.account.client.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DeductBalanceRequest
 *
 * @author hein
 */
@Data
public class DeductBalanceRequest implements Serializable {

    private Long accountId;

    private BigDecimal price;
}
