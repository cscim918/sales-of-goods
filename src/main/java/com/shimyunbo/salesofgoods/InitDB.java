package com.shimyunbo.salesofgoods;

import com.shimyunbo.salesofgoods.domain.Order;
import com.shimyunbo.salesofgoods.domain.OrderProduct;
import com.shimyunbo.salesofgoods.domain.Product;
import com.shimyunbo.salesofgoods.domain.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            Product product1 = createProduct("맥북프로", 3400000, 100, ProductStatus.SALE, "애플", 1001 ,LocalDateTime.now(), LocalDateTime.now());
            em.persist(product1);

            Product product2 = createProduct("문화상품권", 100000, 200,ProductStatus.SALE, "기프티콘", 1002 ,LocalDateTime.now(), LocalDateTime.now());
            em.persist(product2);

            Product product3 = createProduct("LPX 데스크탑 메모리 32GB", 143880, 300,ProductStatus.SALE, "하이닉스", 1003 ,LocalDateTime.now(), LocalDateTime.now());
            em.persist(product3);

            OrderProduct orderProduct1 = OrderProduct.createOrderProduct(product1, 10);
            OrderProduct orderProduct2 = OrderProduct.createOrderProduct(product2, 20);
            Order order1 = Order.createOrder("서울시 동작구", orderProduct1, orderProduct2);
            em.persist(order1);

            OrderProduct orderProduct3 = OrderProduct.createOrderProduct(product3, 10);
            Order order2 = Order.createOrder("경기도 과천시", orderProduct3, orderProduct2);
            em.persist(order2);
        }

        private Product createProduct(String productName, int price, int stockQuantity,ProductStatus productStatus, String sellerName, int sellerId, LocalDateTime startDate, LocalDateTime closingDate) {
            Product product = new Product();
            product.setProductName(productName);
            product.setPrice(price);
            product.setStockQuantity(stockQuantity);
            product.setProductStatus(productStatus);
            product.setSellerName(sellerName);
            product.setSellerId(sellerId);
            product.setStartDate(startDate);
            product.setClosingDate(closingDate);
            return product;
        }
    }
}
