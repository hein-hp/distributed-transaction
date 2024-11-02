package distributed.transaction.storage.core.application.servcie.impl;

import distributed.transaction.storage.core.application.servcie.ProductService;
import distributed.transaction.storage.core.domain.procuct.entity.Product;
import distributed.transaction.storage.core.domain.procuct.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 *
 * @author hein
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDomainService productDomainService;

    @Override
    public Boolean checkStorage(Product product) {
        return productDomainService.checkStorage(product);
    }

    @Override
    public void deductStorage(Product product) {
        productDomainService.deductStorage(product);
    }

    @Override
    public Product queryProduct(Product product) {
        return productDomainService.queryProduct(product);
    }
}
