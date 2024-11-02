package distributed.transaction.account.client.service;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.account.client.dto.resp.CheckBalanceResponse;

/**
 * AccountApiService
 *
 * @author hein
 */
public interface AccountApiService {

    CheckBalanceResponse checkBalance(CheckBalanceRequest request);

    void deductBalance(DeductBalanceRequest request);
}
