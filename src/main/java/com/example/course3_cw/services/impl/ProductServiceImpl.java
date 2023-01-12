package com.example.course3_cw.services.impl;

import com.example.course3_cw.model.Product;
import com.example.course3_cw.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ProductServiceImpl implements ProductService {
    private static Long lastId = 0L;
    Map<Long, Product> productMap = new TreeMap<>();
    @Override
    public Collection<Product> getAllProduct() {
        return productMap.values();
    }
    @Override
    public Product add(Product product) {
        if (productMap.containsKey(lastId)) {
            throw new RuntimeException("Нельзя добавить дубликат носков");
        } else {
            productMap.put(lastId++, product);
        }
        return product;
    }
    @Override
    public Product getById(Long lastId) {
        if (productMap.containsKey(lastId)) {
            return productMap.get(lastId);
        } else {
            throw new RuntimeException("Нет таких носков");
        }
    }
    @Override
    public Product deleteById(Long lastId) {
        return productMap.remove(lastId);
    }
    @Override
    public Product updateById(Long lastId, Product product) {
        Product serviceProduct = productMap.get(lastId);
        if (serviceProduct == null) {
            throw new RuntimeException("Носки не найден");
        }
        productMap.replace(lastId, product);
        return product;
    }
}

