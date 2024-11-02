package distributed.transaction.storage.core.domain.procuct.service;

import distributed.transaction.storage.core.domain.procuct.entity.Product;

/**
 * ProductDomainService
 *
 * @author hein
 */
public interface ProductDomainService {

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
