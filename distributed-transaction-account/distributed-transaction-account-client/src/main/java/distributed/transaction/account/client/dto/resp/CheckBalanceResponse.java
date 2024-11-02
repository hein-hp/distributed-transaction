package distributed.transaction.account.client.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * CheckBalanceResponse
 *
 * @author hein
 */
@Data
public class CheckBalanceResponse implements Serializable {

    private Boolean isEnough;
}
