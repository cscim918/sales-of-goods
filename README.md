# sales-of-goods

# 상품 판매 API
# 

### 상품 조회, 주문, 주문 취소, 주문 내역 조회 API 구현
### 

### 한 번 주문할 때 여러 상품을 선택할 수 있으므로 주문과 상품은 다대다 관계
### 연결 테이블 생성 후 일대다, 다대일 관계로 설계
#### 

### 상품 테이블 - 상품 id, 상품명, 상품금액, 재고수량, 상품상태[판매중, 판매중지], 판매자 id, 판매자명, 전시 시작일, 전시 종료일
### 주문 테이블 - 주문 id, 배송지
### 상품-주문 연결테이블 - 연결 테이블 id, 주문금액, 주문수량, 주문 id(fk), 상품 id(fk)
#### 

#### 상품 조회 API(GET) - 80%
##### - 요청 : 상품 전시기간(display_date)
##### - 응답 : 상품식별값, 상품명, 금액, 재고(남은 수량), 셀러 아이디, 셀러명, 상품상태(판매중, 판매중지)
#### 

#### 상품 주문 API(POST) - 0%
##### - 요청 : 사용자 식별값, 상품 식별값, 주문금액, 배송지, 주문수량
##### - 응답 : 정상 주문 시 성공 응답, 재고 소진 및 판매 중지 시 실패 응답
#### 

#### 상품 주문 취소 API(DELETE) - 0%
##### - 요청 : 상품 전시기간(display_date)
##### - 응답 : 정상 주문 취소 시 성공 응답, 주문 취소 실패 시 실패 응답
#### 

#### 주문 내역 조회 API(GET) - 80%
##### - 요청 : 사용자 식별값, 조회 기간
##### - 응답 : 주문식별값, 상품명, 상품 금액, 배송지, 주문금액, 주문수량
#### 

#### 상품 조회 및 주문 내역 조회 API는 조회 기간에 따른 검색 기능 추가 구현 필요
#### 상품 주문과 상품 주문 취소 API는 미구현 상태
