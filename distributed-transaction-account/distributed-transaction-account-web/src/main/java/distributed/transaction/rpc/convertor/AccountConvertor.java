package distributed.transaction.rpc.convertor;

import distributed.transaction.account.client.dto.req.CheckBalanceRequest;
import distributed.transaction.account.client.dto.req.DeductBalanceRequest;
import distributed.transaction.account.core.domain.procuct.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ProductConvertor
 *
 * @author hein
 */
@Mapper
public interface AccountConvertor {

    AccountConvertor INSTANCE = Mappers.getMapper(AccountConvertor.class);

    @Mapping(target = "id", source = "accountId")
    @Mapping(target = "balance", source = "price")
    Account toAccount(CheckBalanceRequest request);

    @Mapping(target = "id", source = "accountId")
    @Mapping(target = "balance", source = "price")
    Account toAccount(DeductBalanceRequest request);
}
