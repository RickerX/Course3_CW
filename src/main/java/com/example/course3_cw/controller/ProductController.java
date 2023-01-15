package com.example.course3_cw.controller;
import com.example.course3_cw.dto.ProductRequest;
import com.example.course3_cw.exception.InSufficientProductQuantityException;
import com.example.course3_cw.exception.InvalidProductRequestException;
import com.example.course3_cw.model.Color;
import com.example.course3_cw.model.Size;
import com.example.course3_cw.services.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name = "Носки", description = "CRUD - операции")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    @Operation(summary = "Добавление носков на склад")
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }

    @PutMapping("/issue")
    @Operation(summary = "Отпуск носков со склада")
    public void issuesProduct(@RequestBody ProductRequest productRequest) {
        productService.issueProduct(productRequest);
    }

    @GetMapping("/get")
    @Operation(summary = "Поиск носков на складе")
    public int getProductCount(@RequestParam(required = false, name = "color") Color color,
                               @RequestParam(required = false, name = "size") Size size,
                               @RequestParam(required = false, name = "cottonMin") Integer cottonMin,
                               @RequestParam(required = false, name = "cottonMax") Integer cottonMax) {
        return productService.getProductQuantity(color, size, cottonMin, cottonMax);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Списание носков со склада")
    public void removeDefectiveProduct(@RequestBody ProductRequest productRequest) {
        productService.removeDefectiveProduct(productRequest);
    }

    @ExceptionHandler(InvalidProductRequestException.class)
    public ResponseEntity<String> handleInvalidException(InvalidProductRequestException invalidProductRequestException) {
        return ResponseEntity.badRequest().body(invalidProductRequestException.getMessage());
    }
    @ExceptionHandler(InvalidProductRequestException.class)
    public ResponseEntity<String> handleInvalidException(InSufficientProductQuantityException inSufficientProductQuantityException) {
        return ResponseEntity.badRequest().body(inSufficientProductQuantityException.getMessage());
    }
}
