package distributed.transaction.order.core.application.adapter;

import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import distributed.transaction.product.client.dto.resp.CheckStorageResponse;
import distributed.transaction.product.client.dto.resp.QueryProductResponse;
import distributed.transaction.product.client.service.ProductApiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * ProductServiceAdapter
 *
 * @author hein
 */
@Component
public class ProductServiceAdapter {

    @DubboReference(timeout = 10000)
    private ProductApiService productApiService;

    public CheckStorageResponse checkStorage(CheckStorageRequest checkStorageRequest) {
        return productApiService.checkStorage(checkStorageRequest);
    }

    public void deductStorage(DeductStorageRequest deductStorageRequest) {
        productApiService.deductStorage(deductStorageRequest);
    }

    public QueryProductResponse queryProduct(QueryProductRequest queryProductRequest) {
        return productApiService.queryProduct(queryProductRequest);
    }
}
