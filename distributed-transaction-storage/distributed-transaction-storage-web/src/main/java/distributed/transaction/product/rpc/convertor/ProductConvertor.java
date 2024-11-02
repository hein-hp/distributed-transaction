package distributed.transaction.product.rpc.convertor;

import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import distributed.transaction.storage.core.domain.procuct.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ProductConvertor
 *
 * @author hein
 */
@Mapper
public interface ProductConvertor {

    ProductConvertor INSTANCE = Mappers.getMapper(ProductConvertor.class);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "storage", source = "quantity")
    Product toProduct(CheckStorageRequest request);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "storage", source = "quantity")
    Product toProduct(DeductStorageRequest request);

    @Mapping(target = "id", source = "productId")
    Product toProduct(QueryProductRequest request);
}
