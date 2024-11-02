package distributed.transaction.account.client.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * CheckBalanceRequest
 *
 * @author hein
 */
@Data
public class CheckBalanceRequest implements Serializable {

    private Long accountId;

    private BigDecimal price;
}
