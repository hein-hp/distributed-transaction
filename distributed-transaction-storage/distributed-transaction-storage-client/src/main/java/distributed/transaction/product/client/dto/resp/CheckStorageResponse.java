package distributed.transaction.product.client.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * CheckStorageResponse
 *
 * @author hein
 */
@Data
public class CheckStorageResponse implements Serializable {

    private Boolean isEnough;
}
