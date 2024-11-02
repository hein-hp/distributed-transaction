package distributed.transaction.account.core.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import distributed.transaction.account.core.infrastructure.entity.AccountDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * AccountMapper
 *
 * @author hein
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {
}
