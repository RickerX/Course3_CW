package com.example.course3_cw.model;
import lombok.Data;
import java.util.Objects;

@Data
public class Socks {
    private final Color color;
    private final Size size;
    private final int cottonPercentage;
    public Socks(Color color, int size, int cottonPercentage) {
        this.color = color;
        this.size = Size.forValues(size);
        this.cottonPercentage = cottonPercentage;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Socks product)) return false;
        return cottonPercentage == product.cottonPercentage && color == product.color && size == product.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, cottonPercentage);
    }
}
