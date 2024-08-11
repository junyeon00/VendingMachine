package spring_practice.vendingmachine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_practice.vendingmachine.dto.ProductDto;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "product") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Product {
    @Id
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "quantity", length = 50, nullable = false)
    private int quantity;

    public void updateQuantity(ProductDto productDto){
        this.quantity = productDto.getQuantity();
    }
}
