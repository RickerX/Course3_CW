package com.example.course3_cw.services;

import com.example.course3_cw.dto.SocksRequest;
import com.example.course3_cw.model.Color;
import com.example.course3_cw.model.Size;

public interface ProductService {
    void addProduct(SocksRequest productRequest);

    void issueProduct(SocksRequest productRequest);

    void removeDefectiveProduct(SocksRequest productRequest);

    void decreaseProductQuantity(SocksRequest productRequest);

    int getProductQuantity(Color color, Size size, Integer cottonMin, Integer cottonMax);
}
