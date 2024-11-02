package distributed.transaction.storage.core.application.servcie;

import distributed.transaction.storage.core.domain.procuct.entity.Product;

/**
 * ProductService
 *
 * @author hein
 */
public interface ProductService {

    /**
     * 检查库存是否充足
     */
    Boolean checkStorage(Product product);

    /**
     * 扣减库存
     */
    void deductStorage(Product product);

    /**
     * 查询商品信息
     */
    Product queryProduct(Product product);
}
