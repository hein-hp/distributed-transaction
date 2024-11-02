package distributed.transaction.storage.core.domain.procuct.service.impl;

import distributed.transaction.storage.core.domain.procuct.entity.Product;
import distributed.transaction.storage.core.domain.procuct.service.ProductDomainService;
import distributed.transaction.storage.core.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductDomainServiceImpl
 *
 * @author hein
 */
@Service
public class ProductDomainServiceImpl implements ProductDomainService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Boolean checkStorage(Product product) {
        return productRepository.checkStorage(product);
    }

    @Override
    public void deductStorage(Product product) {
        productRepository.deductStorage(product);
    }

    @Override
    public Product queryProduct(Product product) {
        return productRepository.queryProduct(product);
    }
}
