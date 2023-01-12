package com.example.course3_cw.services;

import com.example.course3_cw.model.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> getAllProduct();

    Product add(Product product);

    Product getById(Long lastId);

    Product deleteById(Long lastId);

    Product updateById(Long lastId, Product product);
}
