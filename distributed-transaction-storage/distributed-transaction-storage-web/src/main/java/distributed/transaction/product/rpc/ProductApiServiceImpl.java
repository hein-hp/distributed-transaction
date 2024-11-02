package distributed.transaction.product.rpc;

import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import distributed.transaction.product.client.dto.resp.CheckStorageResponse;
import distributed.transaction.product.client.dto.resp.QueryProductResponse;
import distributed.transaction.product.client.service.ProductApiService;
import distributed.transaction.product.rpc.convertor.ProductConvertor;
import distributed.transaction.storage.core.application.servcie.ProductService;
import distributed.transaction.storage.core.domain.procuct.entity.Product;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ProductApiServiceImpl
 *
 * @author hein
 */
@DubboService
public class ProductApiServiceImpl implements ProductApiService {

    @Autowired
    private ProductService productService;

    @Override
    public CheckStorageResponse checkStorage(CheckStorageRequest request) {
        Product product = ProductConvertor.INSTANCE.toProduct(request);
        Boolean isEnough = productService.checkStorage(product);
        CheckStorageResponse response = new CheckStorageResponse();
        response.setIsEnough(isEnough);
        return response;
    }

    @Override
    public void deductStorage(DeductStorageRequest request) {
        Product product = ProductConvertor.INSTANCE.toProduct(request);
        productService.deductStorage(product);
    }

    @Override
    public QueryProductResponse queryProduct(QueryProductRequest request) {
        Product product = ProductConvertor.INSTANCE.toProduct(request);
        QueryProductResponse response = new QueryProductResponse();
        response.setPrice(productService.queryProduct(product).getPrice());
        return response;
    }
}
