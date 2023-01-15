package com.example.course3_cw.services;

import com.example.course3_cw.dto.ProductRequest;
import com.example.course3_cw.model.Color;
import com.example.course3_cw.model.Size;

public interface ProductService {
    void addProduct(ProductRequest productRequest);

    void issueProduct(ProductRequest productRequest);

    void removeDefectiveProduct(ProductRequest productRequest);

    void decreaseProductQuantity(ProductRequest productRequest);

    int getProductQuantity(Color color, Size size, Integer cottonMin, Integer cottonMax);
}
