package distributed.transaction.account.core.domain.procuct.service;

import distributed.transaction.account.core.domain.procuct.entity.Account;

/**
 * AccountDomainService
 *
 * @author hein
 */
public interface AccountDomainService {

    /**
     * 检查余额是否充足
     */
    Boolean checkBalance(Account account);

    /**
     * 扣减余额
     */
    void deductBalance(Account account);
}
