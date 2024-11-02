package distributed.transaction.storage.core.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import distributed.transaction.storage.core.domain.procuct.entity.Product;
import distributed.transaction.storage.core.infrastructure.convertor.ProductConvertor;
import distributed.transaction.storage.core.infrastructure.entity.ProductDO;
import distributed.transaction.storage.core.infrastructure.mapper.ProductMapper;
import distributed.transaction.storage.core.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ProductRepositoryImpl
 *
 * @author hein
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Boolean checkStorage(Product product) {
        ProductDO productDO = ProductConvertor.INSTANCE.toProductDO(product);
        LambdaQueryWrapper<ProductDO> queryWrapper = Wrappers.lambdaQuery(ProductDO.class)
                .eq(ProductDO::getId, productDO.getId());
        ProductDO res = productMapper.selectOne(queryWrapper);
        return res.getStorage() >= product.getStorage();
    }

    @Override
    public void deductStorage(Product product) {
        ProductDO productDO = ProductConvertor.INSTANCE.toProductDO(product);
        LambdaUpdateWrapper<ProductDO> updateWrapper = Wrappers.lambdaUpdate(ProductDO.class)
                .eq(ProductDO::getId, productDO.getId())
                .set(ProductDO::getStorage, productDO.getStorage() - product.getStorage());
        productMapper.update(null, updateWrapper);
    }

    @Override
    public Product queryProduct(Product product) {
        ProductDO productDO = ProductConvertor.INSTANCE.toProductDO(product);
        LambdaQueryWrapper<ProductDO> queryWrapper = Wrappers.lambdaQuery(ProductDO.class)
                .eq(ProductDO::getId, productDO.getId());
        return ProductConvertor.INSTANCE.toProduct(productMapper.selectOne(queryWrapper));
    }
}
