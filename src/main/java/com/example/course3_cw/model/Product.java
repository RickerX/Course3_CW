package com.example.course3_cw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String socksColor;
    private String socksSize;
    private int compositionOfSocks;
    private String presenceOfSocks;
    private String quantity;
}
