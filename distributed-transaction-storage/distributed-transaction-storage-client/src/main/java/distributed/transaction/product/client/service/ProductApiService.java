package distributed.transaction.product.client.service;

import distributed.transaction.product.client.dto.req.CheckStorageRequest;
import distributed.transaction.product.client.dto.req.DeductStorageRequest;
import distributed.transaction.product.client.dto.req.QueryProductRequest;
import distributed.transaction.product.client.dto.resp.CheckStorageResponse;
import distributed.transaction.product.client.dto.resp.QueryProductResponse;

/**
 * ProductApiService
 *
 * @author hein
 */
public interface ProductApiService {

    /**
     * 检查库存是否充足
     */
    CheckStorageResponse checkStorage(CheckStorageRequest request);

    /**
     * 扣减库存
     */
    void deductStorage(DeductStorageRequest request);

    /**
     * 查询商品信息
     */
    QueryProductResponse queryProduct(QueryProductRequest queryProductRequest);
}
