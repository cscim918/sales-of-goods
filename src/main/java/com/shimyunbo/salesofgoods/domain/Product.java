package com.shimyunbo.salesofgoods.domain;

import com.shimyunbo.salesofgoods.exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String productName;
    private int price;
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus; // 상품상태 [SALE, NFS]

    private int sellerId;
    private String sellerName;
    private LocalDateTime startDate;
    private LocalDateTime closingDate;

    // 비즈니스 로직

    public void addStock(int quantity) { // 변경해야 할 일이 있으면 Setter를 쓰지말고 이렇게 핵심 비즈니스 메소드로 변경해야 한다.
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 없습니다.");
        }
        this.stockQuantity = restStock;
    }
}
