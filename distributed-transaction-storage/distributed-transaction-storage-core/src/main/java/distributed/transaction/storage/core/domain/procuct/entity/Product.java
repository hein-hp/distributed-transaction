package distributed.transaction.storage.core.domain.procuct.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Product
 *
 * @author hein
 */
@Data
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    private Integer storage;
}
