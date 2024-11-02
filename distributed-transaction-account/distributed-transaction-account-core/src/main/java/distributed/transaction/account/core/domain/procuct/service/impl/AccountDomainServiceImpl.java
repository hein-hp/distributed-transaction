package distributed.transaction.account.core.domain.procuct.service.impl;

import distributed.transaction.account.core.domain.procuct.entity.Account;
import distributed.transaction.account.core.domain.procuct.service.AccountDomainService;
import distributed.transaction.account.core.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountDomainServiceImpl
 *
 * @author hein
 */
@Service
public class AccountDomainServiceImpl implements AccountDomainService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Boolean checkBalance(Account account) {
        return accountRepository.checkBalance(account);
    }

    @Override
    public void deductBalance(Account account) {
        accountRepository.deductBalance(account);
    }
}
