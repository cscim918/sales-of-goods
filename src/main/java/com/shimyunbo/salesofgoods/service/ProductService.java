package com.shimyunbo.salesofgoods.service;

import com.shimyunbo.salesofgoods.domain.Product;
import com.shimyunbo.salesofgoods.repository.ProductRepository;
import com.shimyunbo.salesofgoods.repository.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAllProduct(){
        return productRepository.findAllProduct().stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }
}
