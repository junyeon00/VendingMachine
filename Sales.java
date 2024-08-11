package spring_practice.vendingmachine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_practice.vendingmachine.dto.ProductDto;

import java.util.List;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "sales") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Sales {
    @Id
    private String name;
    @Column(name = "profit", nullable = false)
    private int profit;

    public void updateProfit(ProductDto productDto) {
        this.profit += productDto.getPrice();
    }
}

