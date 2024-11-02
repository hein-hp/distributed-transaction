package distributed.transaction.rpc;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.account.client.dto.resp.CheckBalanceResponse;
import distributed.transaction.account.client.service.AccountApiService;
import distributed.transaction.account.core.application.servcie.AccountService;
import distributed.transaction.account.core.domain.procuct.entity.Account;
import distributed.transaction.rpc.convertor.AccountConvertor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AccountApiServiceImpl
 *
 * @author hein
 */
@DubboService
public class AccountApiServiceImpl implements AccountApiService {

    @Autowired
    private AccountService accountService;

    @Override
    public CheckBalanceResponse checkBalance(CheckBalanceRequest request) {
        Account account = AccountConvertor.INSTANCE.toAccount(request);
        Boolean isEnough = accountService.checkBalance(account);
        CheckBalanceResponse response = new CheckBalanceResponse();
        response.setIsEnough(isEnough);
        return response;
    }

    @Override
    public void deductBalance(DeductBalanceRequest request) {
        Account account = AccountConvertor.INSTANCE.toAccount(request);
        accountService.deductBalance(account);
    }
}
