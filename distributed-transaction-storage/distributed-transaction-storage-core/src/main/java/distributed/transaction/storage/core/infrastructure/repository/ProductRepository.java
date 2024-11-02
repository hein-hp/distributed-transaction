package distributed.transaction.storage.core.infrastructure.repository;

import distributed.transaction.storage.core.domain.procuct.entity.Product;

/**
 * ProductRepository
 *
 * @author hein
 */
public interface ProductRepository {

    Boolean checkStorage(Product product);

    void deductStorage(Product product);

    Product queryProduct(Product product);
}
