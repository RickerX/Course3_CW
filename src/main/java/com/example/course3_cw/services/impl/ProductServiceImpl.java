package com.example.course3_cw.services.impl;
import com.example.course3_cw.dto.SocksRequest;
import com.example.course3_cw.exception.InSufficientProductQuantityException;
import com.example.course3_cw.exception.InvalidProductRequestException;
import com.example.course3_cw.model.Color;
import com.example.course3_cw.model.Socks;
import com.example.course3_cw.model.Size;
import com.example.course3_cw.services.ProductService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {
    private final Map<Socks, Integer> socks = new HashMap<>();
    @Override
    public void addProduct(SocksRequest productRequest) {
        validateRequest(productRequest);
        Socks product = mapToProduct(productRequest);
        if (socks.containsKey(product)) {
            socks.put(product, socks.get(product) + productRequest.getQuantity());
        } else {
            socks.put(product, productRequest.getQuantity());
        }
    }
    @Override
    public void issueProduct(SocksRequest productRequest) {
       decreaseProductQuantity(productRequest);
    }
    @Override
    public void removeDefectiveProduct(SocksRequest productRequest) {
        decreaseProductQuantity(productRequest);

    }
    @Override
    public void decreaseProductQuantity(SocksRequest productRequest) {
        validateRequest(productRequest);
        Socks product = mapToProduct(productRequest);
        int productQuantity = socks.getOrDefault(product,0);
        if (productQuantity >= productRequest.getQuantity()) {
            socks.remove(product, productQuantity - productRequest.getQuantity());
        } else {
            throw new InSufficientProductQuantityException("Носков больше нет");
        }
    }
    @Override
    public int getProductQuantity(Color color, Size size, Integer cottonMin, Integer cottonMax) {
        int total = 0;
        for (Map.Entry<Socks, Integer> entry : socks.entrySet()) {
            if (color != null && !entry.getKey().getColor().equals(color)) {
                continue;
            }
            if (size != null && !entry.getKey().getSize().equals(size)) {
                continue;
            }
            if (cottonMin != null && entry.getKey().getCottonPercentage() < cottonMin) {
                continue;
            }
            if (cottonMax != null && entry.getKey().getCottonPercentage() > cottonMax) {
                continue;
            }
            total += entry.getValue();
        }
        return total;
    }

    private void validateRequest(SocksRequest productRequest) {
        if (productRequest.getColor() == null || productRequest.getSize() == null) {
            throw new InvalidProductRequestException("Все поля должны быть заполнены.");
        }
        if (productRequest.getQuantity() <= 0) {
            throw new InvalidProductRequestException("Должна быть минимум 1 пара носков.");
        }
        if (productRequest.getCottonPercentage() < 0 || productRequest.getCottonPercentage() > 100) {
            throw new InvalidProductRequestException("Процент хлопка не может быть меньше 0 или больше 100.");
        }
    }

    private Socks mapToProduct(SocksRequest productRequest) {
        return new Socks(productRequest.getColor(),
                productRequest.getSize().ordinal(),
                productRequest.getCottonPercentage());
    }

}

