package distributed.transaction.account.core.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import distributed.transaction.account.core.domain.procuct.entity.Account;
import distributed.transaction.account.core.infrastructure.convertor.AccountConvertor;
import distributed.transaction.account.core.infrastructure.entity.AccountDO;
import distributed.transaction.account.core.infrastructure.mapper.AccountMapper;
import distributed.transaction.account.core.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * AccountRepositoryImpl
 *
 * @author hein
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean checkBalance(Account account) {
        AccountDO accountDO = AccountConvertor.INSTANCE.toAccountDO(account);
        LambdaQueryWrapper<AccountDO> queryWrapper = Wrappers.lambdaQuery(AccountDO.class)
                .eq(AccountDO::getId, accountDO.getId());
        AccountDO res = accountMapper.selectOne(queryWrapper);
        return res.getBalance().compareTo(account.getBalance()) >= 0;
    }

    @Override
    public void deductBalance(Account account) {
        BigDecimal subtract = account.getBalance();
        AccountDO accountDO = AccountConvertor.INSTANCE.toAccountDO(account);
        LambdaQueryWrapper<AccountDO> queryWrapper = Wrappers.lambdaQuery(AccountDO.class)
                .eq(AccountDO::getId, accountDO.getId());
        AccountDO res = accountMapper.selectOne(queryWrapper);
        BigDecimal current = res.getBalance();
        LambdaUpdateWrapper<AccountDO> updateWrapper = Wrappers.lambdaUpdate(AccountDO.class)
                .eq(AccountDO::getId, accountDO.getId())
                .set(AccountDO::getBalance, current.subtract(subtract));
        accountMapper.update(null, updateWrapper);
    }
}
