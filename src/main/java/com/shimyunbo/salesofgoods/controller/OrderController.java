package com.shimyunbo.salesofgoods.controller;

import com.shimyunbo.salesofgoods.repository.dto.OrderDto;
import com.shimyunbo.salesofgoods.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/api/v1/orders")
    public List<OrderDto> findAllOrders(){
        return orderService.findAllOrder();
    }
}
