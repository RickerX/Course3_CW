package com.example.course3_cw.dto;
import com.example.course3_cw.model.Color;
import com.example.course3_cw.model.Size;

public class SocksRequest {
    private final Color color;
    private final Size size;
    private final int cottonPercentage;
    private final int quantity;

    public SocksRequest(Color color, Size size, int cottonPercentage, int quantity) {
        this.color = color;
        this.size = size;
        this.cottonPercentage = cottonPercentage;
        this.quantity = quantity;
    }

    public Color getColor() {
        return color;
    }
    public Size getSize() {
        return size;
    }

    public int getCottonPercentage() {
        return cottonPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

}
