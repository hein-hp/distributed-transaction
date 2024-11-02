package distributed.transaction.account.core.infrastructure.convertor;

import distributed.transaction.account.core.domain.procuct.entity.Account;
import distributed.transaction.account.core.infrastructure.entity.AccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountConvertor
 *
 * @author hein
 */
@Mapper
public interface AccountConvertor {

    AccountConvertor INSTANCE = Mappers.getMapper(AccountConvertor.class);

    AccountDO toAccountDO(Account account);
}
