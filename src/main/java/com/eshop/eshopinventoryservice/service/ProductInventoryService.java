package com.eshop.eshopinventoryservice.service;


import com.eshop.eshopinventoryservice.model.ProductInventory;

/**
 * 商品库存服务接口
 */
public interface ProductInventoryService {

    void add(ProductInventory productInventory);

    void update(ProductInventory productInventory);

    void delete(Long id);

    ProductInventory findById(Long id);

    ProductInventory findByProductId(Long productId);
}
