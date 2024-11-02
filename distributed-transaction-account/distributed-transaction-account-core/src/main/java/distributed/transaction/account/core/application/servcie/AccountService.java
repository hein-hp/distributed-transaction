package distributed.transaction.account.core.application.servcie;

import distributed.transaction.account.core.domain.procuct.entity.Account;

/**
 * AccountService
 *
 * @author hein
 */
public interface AccountService {

    /**
     * 检查余额是否充足
     */
    Boolean checkBalance(Account account);

    /**
     * 扣减余额
     */
    void deductBalance(Account account);
}
