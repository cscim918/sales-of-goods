package com.shimyunbo.salesofgoods.repository;

import com.shimyunbo.salesofgoods.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderProduct, Long> {

    @Query("select op from OrderProduct op join op.order o")
    List<OrderProduct> findAllOrder();
}
