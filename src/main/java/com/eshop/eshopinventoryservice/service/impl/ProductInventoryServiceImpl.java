package com.eshop.eshopinventoryservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.eshopinventoryservice.mapper.ProductInventoryMapper;
import com.eshop.eshopinventoryservice.model.ProductInventory;
import com.eshop.eshopinventoryservice.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 商品库存服务接口实现类
 */
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Autowired
    private ProductInventoryMapper productInventoryMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void add(ProductInventory productInventory) {
        productInventoryMapper.add(productInventory);
        redisTemplate.opsForValue().set("product_inventory:" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void update(ProductInventory productInventory) {
        productInventoryMapper.update(productInventory);
        redisTemplate.opsForValue().set("product_inventory:" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
    }

    @Override
    public void delete(Long id) {
        ProductInventory productInventory = productInventoryMapper.findById(id);
        productInventoryMapper.delete(id);
        redisTemplate.opsForValue().getOperations().delete("product_inventory:" + productInventory.getProductId());
    }

    @Override
    public ProductInventory findById(Long id) {
        return productInventoryMapper.findById(id);
    }

}
