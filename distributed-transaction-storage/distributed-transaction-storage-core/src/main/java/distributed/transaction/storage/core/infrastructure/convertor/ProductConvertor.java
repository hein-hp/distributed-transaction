package distributed.transaction.storage.core.infrastructure.convertor;

import distributed.transaction.storage.core.domain.procuct.entity.Product;
import distributed.transaction.storage.core.infrastructure.entity.ProductDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ProductConvertor
 *
 * @author hein
 */
@Mapper
public interface ProductConvertor {

    ProductConvertor INSTANCE = Mappers.getMapper(ProductConvertor.class);

    ProductDO toProductDO(Product product);

    Product toProduct(ProductDO productDO);
}
