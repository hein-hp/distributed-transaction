package distributed.transaction.account.core.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * AccountDO
 *
 * @author hein
 */
@TableName("t_account")
@Data
public class AccountDO {

    /**
     * 账户 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 账户人
     */
    private String username;

    /**
     * 账户余额
     */
    private BigDecimal balance;
}