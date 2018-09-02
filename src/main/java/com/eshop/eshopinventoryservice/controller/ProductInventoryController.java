package com.eshop.eshopinventoryservice.controller;

import com.eshop.eshopinventoryservice.model.ProductInventory;
import com.eshop.eshopinventoryservice.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-inventory")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @GetMapping("/add")
    public String add(ProductInventory productInventory) {
        try {
            productInventoryService.add(productInventory);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductInventory productInventory) {
        try {
            productInventoryService.update(productInventory);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        try {
            productInventoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public ProductInventory findById(Long id) {
        try {
            return productInventoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductInventory();
    }

}
