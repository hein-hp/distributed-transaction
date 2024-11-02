package distributed.transaction.order.core.application.adapter;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.account.client.dto.resp.CheckBalanceResponse;
import distributed.transaction.account.client.service.AccountApiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * AccountServiceAdapter
 *
 * @author hein
 */
@Component
public class AccountServiceAdapter {

    @DubboReference(timeout = 10000)
    private AccountApiService accountApiService;

    public CheckBalanceResponse checkBalance(CheckBalanceRequest request) {
        return accountApiService.checkBalance(request);
    }

    public void deductBalance(DeductBalanceRequest request) {
        accountApiService.deductBalance(request);
    }
}
