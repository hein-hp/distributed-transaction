package distributed.transaction.storage.core.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import distributed.transaction.storage.core.infrastructure.entity.ProductDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProductMapper
 *
 * @author hein
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductDO> {
}
