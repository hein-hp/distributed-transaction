package distributed.transaction.order.core.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import distributed.transaction.order.core.infrastructure.model.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * OrderMapper
 *
 * @author hein
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
}
