package com.shimyunbo.salesofgoods.repository.dto;

import com.shimyunbo.salesofgoods.domain.OrderProduct;
import lombok.Getter;

@Getter
public class OrderDto {
    private Long id;
    private String productName;
    private int price;
    private String address;
    private int orderPrice;
    private int orderCount;

    public OrderDto(OrderProduct orderProduct){
        this.id = orderProduct.getOrder().getId();
        this.productName = orderProduct.getProduct().getProductName();
        this.price = orderProduct.getProduct().getPrice();
        this.address = orderProduct.getOrder().getAddress();
        this.orderPrice = orderProduct.getOrderPrice();
        this.orderCount = orderProduct.getCount();
    }
}