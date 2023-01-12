package com.example.course3_cw.controller;

import com.example.course3_cw.model.Product;
import com.example.course3_cw.services.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
@Tag(name = "Носки", description = "CRUD - операции")
public class ProductController {
    public final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    @Operation(summary = "Поиск всех носков")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки были найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    public Collection<Product> getAll() {
        return this.productService.getAllProduct();
    }
    @PostMapping("/")
    @Operation(summary = "Добавление носков")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиенты были найдены добавлены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    public Product addProduct(@RequestBody Product product) {
        return this.productService.add(product);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Поиск носков по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиенты были найдены по id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    public Product getProductById(@PathVariable("id") Long id) {
        return this.productService.getById(id);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление носков по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки были удалены по id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    public Product deleteProductById(@PathVariable("id") Long id) {
        return this.productService.deleteById(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Обновление носков по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "носки были обновлены по id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
                            )
                    }
            )
    })
    public Product updateIngredientsById(@PathVariable Long id, @RequestBody Product product) {
        return this.productService.updateById(id, product);
    }
}
