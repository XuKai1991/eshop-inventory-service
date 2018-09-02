package com.eshop.eshopinventoryservice.mapper;

import com.eshop.eshopinventoryservice.model.ProductInventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductInventoryMapper {

    @Insert("insert into product_inventory(value, product_id) values(#{value}, #{productId})")
    @SelectKey(keyColumn = "id", keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = "select last_insert_id()")
    void add(ProductInventory productInventory);

    @Update("update product_inventory set value=#{value}, product_id=#{productId} where id=#{id}")
    void update(ProductInventory productInventory);

    @Delete("delete from product_inventory where id=#{id}")
    void delete(Long id);

    @Select("select * from product_inventory where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "value", property = "value"),
            @Result(column = "product_id", property = "productId")
    })
    ProductInventory findById(Long id);

}
