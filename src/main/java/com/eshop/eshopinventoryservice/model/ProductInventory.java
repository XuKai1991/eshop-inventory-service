package com.eshop.eshopinventoryservice.model;

import lombok.Data;

/**
 * 商品库存实体类
 */
@Data
public class ProductInventory {

    private Long id;

    private Integer value;

    private Long productId;

}
