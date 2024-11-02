package distributed.transaction.account.core.infrastructure.repository;


import distributed.transaction.account.core.domain.procuct.entity.Account;

/**
 * AccountRepository
 *
 * @author hein
 */
public interface AccountRepository {

    Boolean checkBalance(Account account);

    void deductBalance(Account account);
}
