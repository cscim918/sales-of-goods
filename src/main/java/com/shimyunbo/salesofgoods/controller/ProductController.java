package com.shimyunbo.salesofgoods.controller;

import com.shimyunbo.salesofgoods.repository.dto.ProductDto;
import com.shimyunbo.salesofgoods.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public List<ProductDto> findAllProducts(){
        return productService.findAllProduct();
    }
}
