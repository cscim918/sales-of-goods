package com.shimyunbo.salesofgoods.repository.dto;

import com.shimyunbo.salesofgoods.domain.Product;
import com.shimyunbo.salesofgoods.domain.ProductStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductDto {
    private Long id;
    private String productName;
    private int price;
    private ProductStatus productStatus;
    private int sellerId;
    private String sellerName;
    private LocalDateTime startDate;
    private LocalDateTime closingDate;

    public ProductDto(Product product){
        this.id = product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.productStatus = product.getProductStatus();
        this.sellerId = product.getSellerId();
        this.sellerName = product.getSellerName();
        this.startDate = product.getStartDate();
        this.closingDate = product.getClosingDate();
    }
}
