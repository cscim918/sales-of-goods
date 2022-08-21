package com.shimyunbo.salesofgoods.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    // 연관관계 메서드
    public void addOrderProduct(OrderProduct orderProduct){
        orderProducts.add(orderProduct);
        orderProduct.setOrder(this);
    }

    // 생성 메서드
    public static Order createOrder(String address, OrderProduct... orderProducts){
        Order order = new Order();
        order.setAddress(address);
        for(OrderProduct orderProduct : orderProducts){
            order.addOrderProduct(orderProduct);
        }
        return order;
    }

    // 전체 주문 가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts){
            totalPrice += orderProduct.getTotalPrice();
        }
        return totalPrice;
    }
}
