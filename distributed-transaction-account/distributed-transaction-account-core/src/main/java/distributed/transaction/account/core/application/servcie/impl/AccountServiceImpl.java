package distributed.transaction.account.core.application.servcie.impl;

import distributed.transaction.account.core.application.servcie.AccountService;
import distributed.transaction.account.core.domain.procuct.entity.Account;
import distributed.transaction.account.core.domain.procuct.service.AccountDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountServiceImpl
 *
 * @author hein
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDomainService accountDomainService;

    @Override
    public Boolean checkBalance(Account account) {
        return accountDomainService.checkBalance(account);
    }

    @Override
    public void deductBalance(Account account) {
        accountDomainService.deductBalance(account);
    }
}
