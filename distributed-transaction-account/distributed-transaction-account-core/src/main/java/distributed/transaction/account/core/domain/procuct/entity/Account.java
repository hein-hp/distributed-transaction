package distributed.transaction.account.core.domain.procuct.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Account
 *
 * @author hein
 */
@Data
public class Account {

    private Long id;

    private String username;

    private BigDecimal balance;
}
