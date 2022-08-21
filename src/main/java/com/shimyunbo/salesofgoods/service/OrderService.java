package com.shimyunbo.salesofgoods.service;

import com.shimyunbo.salesofgoods.repository.OrderRepository;
import com.shimyunbo.salesofgoods.repository.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAllOrder(){
        return orderRepository.findAllOrder().stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }
}
